package com.shawn.mall.portal.service.impl;

import com.shawn.mall.model.*;
import com.shawn.mall.portal.dao.PortalProductDao;
import com.shawn.mall.portal.domain.CartPromotionItem;
import com.shawn.mall.portal.domain.PromotionProduct;
import com.shawn.mall.portal.service.OmsPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Promotion service impl
 */
@Service
public class OmsPromotionServiceImpl implements OmsPromotionService {
    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {
        //Group cart item base on product it, use spu as unit
        Map<Long,List<OmsCartItem>> productCartMap = groupCartItemBySpu(cartItemList);
        //Search all product related promotion
        List<PromotionProduct> promotionProductList = getPromotionProductList(cartItemList);
        //Cal product promotion price base on product promotion type
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for(Map.Entry<Long,List<OmsCartItem>> entry:productCartMap.entrySet()) {
            Long productId = entry.getKey();
            PromotionProduct promotionProduct = getPromotionProductById(productId,promotionProductList);
            List<OmsCartItem> itemList = entry.getValue();
            Integer promotionType = promotionProduct.getPromotionType();
            if(promotionType==1) {
                //Single product sale
                for(OmsCartItem item:itemList) {
                    CartPromotionItem cartPromotionItem = new CartPromotionItem();
                    BeanUtils.copyProperties(item,cartPromotionItem);
                    cartPromotionItem.setPromotionMessage("Single sale");
                    //Product original - promotion
                    PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
                    BigDecimal originalPrice = skuStock.getPrice();
                    //Single sale use original
                    cartPromotionItem.setPrice(originalPrice);
                    cartPromotionItem.setReduceAmount(originalPrice.subtract(skuStock.getPromotionPrice()));
                    cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                    cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                    cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                    cartPromotionItemList.add(cartPromotionItem);
                }
            } else if(promotionType == 3) {
                //Promotion sale
                int count = getCartItemCount(itemList);
                PmsProductLadder ladder = getProductLadder(count,promotionProduct.getProductLadderList());
                if (ladder != null) {
                    for(OmsCartItem item:itemList) {
                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item,cartPromotionItem);
                        String message = getLadderPromotionMessage(ladder);
                        cartPromotionItem.setPromotionMessage(message);
                        //Price original-Promotion * original
                        PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
                        BigDecimal originalPrice = skuStock.getPrice();
                        BigDecimal reduceAmount = originalPrice.subtract(ladder.getDiscount().multiply(originalPrice));
                        cartPromotionItem.setReduceAmount(reduceAmount);
                        cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                        cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                        cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                        cartPromotionItemList.add(cartPromotionItem);
                    }
                } else{
                    handleNoReduce(cartPromotionItemList,itemList,promotionProduct);
                }
            } else if(promotionType == 4) {
                //Full reduction
                BigDecimal totalAmount = getCartItemAmount(itemList,promotionProductList);
                PmsProductFullReduction fullReduction = getProductFullReduction(totalAmount,promotionProduct.getProductFullReductionList());
                if (fullReduction != null) {
                    for(OmsCartItem item:itemList){
                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item,cartPromotionItem);
                        String message = getFullReductionPromotionMessage(fullReduction);
                        cartPromotionItem.setPromotionMessage(message);
                        //(Original/total)*full reduce
                        PmsSkuStock skuStock= getOriginalPrice(promotionProduct, item.getProductSkuId());
                        BigDecimal originalPrice = skuStock.getPrice();
                        BigDecimal reduceAmount = originalPrice.divide(totalAmount, RoundingMode.HALF_EVEN).multiply(fullReduction.getReducePrice());
                        cartPromotionItem.setReduceAmount(reduceAmount);
                        cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                        cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                        cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                        cartPromotionItemList.add(cartPromotionItem);
                    }
                } else {
                    handleNoReduce(cartPromotionItemList,itemList,promotionProduct);
                }
            } else {
                handleNoReduce(cartPromotionItemList,itemList,promotionProduct);
            }
        }
        return cartPromotionItemList;
    }

    /**
     * Search all product related promotion
     */
    private List<PromotionProduct> getPromotionProductList(List<OmsCartItem> cartItemList) {
        List<Long> productIdList = new ArrayList<>();
        for(OmsCartItem cartItem:cartItemList) {
            productIdList.add(cartItem.getProductId());
        }
        return portalProductDao.getPromotionProductList(productIdList);
    }

    /**
     * Group product base on spu
     */
    private Map<Long,List<OmsCartItem>> groupCartItemBySpu (List<OmsCartItem> cartItemList) {
        Map<Long,List<OmsCartItem>> productCartMap = new TreeMap<>();
        for(OmsCartItem cartItem:cartItemList) {
            List<OmsCartItem> productCartItemList = productCartMap.get(cartItem.getProductId());
            if(productCartItemList == null) {
                productCartItemList = new ArrayList<>();
                productCartItemList.add(cartItem);
                productCartMap.put(cartItem.getProductId(),productCartItemList);
            }else {
                productCartItemList.add(cartItem);
            }
        }
        return productCartMap;
    }

    /**
     * Get full reduction info
     */
    private String getFullReductionPromotionMessage(PmsProductFullReduction fullReduction) {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Reduction:");
        sb.append("Spend");
        sb.append(fullReduction.getFullPrice());
        sb.append("$");
        sb.append(fullReduction.getReducePrice());
        sb.append("off");
        return sb.toString();
    }

    /**
     * Handle not promotional product
     */
    private void handleNoReduce(List<CartPromotionItem> cartPromotionItemList,List<OmsCartItem> itemList,PromotionProduct promotionProduct) {
        for(OmsCartItem item:itemList) {
            CartPromotionItem cartPromotionItem = new CartPromotionItem();
            BeanUtils.copyProperties(item,cartPromotionItem);
            cartPromotionItem.setPromotionMessage("No sale");
            cartPromotionItem.setReduceAmount(new BigDecimal(0));
            PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
            if(skuStock!=null) {
                cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
            }
            cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
            cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
            cartPromotionItemList.add(cartPromotionItem);
        }
    }

    private PmsProductFullReduction getProductFullReduction(BigDecimal totalAmount,List<PmsProductFullReduction> fullReductionList) {
        //Sorting from high to low
        fullReductionList.sort(new Comparator<PmsProductFullReduction>() {
            @Override
            public int compare(PmsProductFullReduction o1, PmsProductFullReduction o2) {
                return o2.getFullPrice().subtract(o1.getFullPrice()).intValue();
            }
        });
        for(PmsProductFullReduction fullReduction:fullReductionList) {
            if(totalAmount.subtract(fullReduction.getFullPrice()).intValue()>=0){
                return fullReduction;
            }
        }
        return null;
    }

    /**
     * Get promotion message
     */
    private String getLadderPromotionMessage(PmsProductLadder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("On Sale:");
        sb.append("Buy");
        sb.append(ladder.getCount());
        sb.append(ladder.getDiscount().multiply(new BigDecimal(10)));
        sb.append("Off");
        return sb.toString();
    }

    /**
     * Get promotion base on product quantity
     */
    private PmsProductLadder getProductLadder(int count,List<PmsProductLadder> productLadderList) {
        //Sorting quantity
        productLadderList.sort(new Comparator<PmsProductLadder>() {
            @Override
            public int compare(PmsProductLadder o1, PmsProductLadder o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        for(PmsProductLadder productLadder:productLadderList) {
            if(count>=productLadder.getCount()){
                return productLadder;
            }
        }
        return null;
    }

    /**
     * Get cart product quantity
     */
    private int getCartItemCount(List<OmsCartItem> itemList) {
        int count =0;
        for(OmsCartItem cartItem:itemList){
            count+=cartItem.getQuantity();
        }
        return count;
    }

    /**
     * Get cart product amount
     */
    private BigDecimal getCartItemAmount(List<OmsCartItem> itemList, List<PromotionProduct> promotionProductList) {
        BigDecimal amount = new BigDecimal(0);
        for(OmsCartItem item:itemList) {
            //
            PromotionProduct promotionProduct = getPromotionProductById(item.getProductId(),promotionProductList);
            PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
            amount = amount.add(skuStock.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return amount;
    }

    /**
     * Get product original price
     */
    private PmsSkuStock getOriginalPrice(PromotionProduct promotionProduct,Long productSkuId) {
        for(PmsSkuStock skuStock:promotionProduct.getSkuStockList()) {
            if(productSkuId.equals(skuStock.getId())){
                return skuStock;
            }
        }
        return null;
    }

    /**
     * Get product promotion info base on product id
     */
    private PromotionProduct getPromotionProductById(Long productId, List<PromotionProduct> promotionProductList) {
        for(PromotionProduct promotionProduct:promotionProductList){
            if(productId.equals(promotionProduct.getId())){
                return promotionProduct;
            }
        }
        return null;
    }
}
