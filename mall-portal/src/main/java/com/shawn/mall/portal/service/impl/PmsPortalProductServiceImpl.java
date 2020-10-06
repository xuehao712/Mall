package com.shawn.mall.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.shawn.mall.mapper.*;
import com.shawn.mall.model.*;
import com.shawn.mall.portal.dao.PortalProductDao;
import com.shawn.mall.portal.domain.PmsPortalProductDetail;
import com.shawn.mall.portal.domain.PmsProductCategoryNode;
import com.shawn.mall.portal.service.PmsPortalProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static jdk.nashorn.api.scripting.ScriptUtils.convert;

/**
 * Front end order service impl
 */
public class PmsPortalProductServiceImpl implements PmsPortalProductService {
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductLadderMapper productLadderMapper;
    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;
    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<PmsProduct> search(String keyword,Long brandId,Long productCategoryId,Integer pageNum,Integer pageSize,Integer sort) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if(StrUtil.isNotEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (brandId != null) {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        //1->new product;2->best sale 3->price low to high;4->price high to low
        if (sort == 1) {
            example.setOrderByClause("id desc");
        } else if (sort == 2) {
            example.setOrderByClause("sale desc");
        } else if (sort == 3) {
            example.setOrderByClause("price asc");
        } else if (sort == 4) {
            example.setOrderByClause("price desc");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategoryNode> categoryTreeList() {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(example);
        List<PmsProductCategoryNode> result = allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> convert(item, allList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public PmsPortalProductDetail detail(Long id) {
        PmsPortalProductDetail result = new PmsPortalProductDetail();
        //Get product info
        PmsProduct product = productMapper.selectByPrimaryKey(id);
        result.setProduct(product);
        //Get brand info
        PmsBrand brand = brandMapper.selectByPrimaryKey(product.getBrandId());
        result.setBrand(brand);
        //Get product attribute
        PmsProductAttributeExample attributeExample = new PmsProductAttributeExample();
        attributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(product.getProductAttributeCategoryId());
        List<PmsProductAttribute> productAttributeList = productAttributeMapper.selectByExample(attributeExample);
        result.setProductAttributeList(productAttributeList);
        //Get product attribute value
        if(CollUtil.isNotEmpty(productAttributeList)) {
            List<Long> attributeIds = productAttributeList.stream().map(PmsProductAttribute::getId).collect(Collectors.toList());
            ;
            PmsProductAttributeValueExample attributeValueExample = new PmsProductAttributeValueExample();
            attributeValueExample.createCriteria().andProductIdEqualTo(product.getId())
                    .andProductAttributeIdIn(attributeIds);
            List<PmsProductAttributeValue> productAttributeValueList = productAttributeValueMapper.selectByExample(attributeValueExample);
            result.setProductAttributeValueList(productAttributeValueList);
        }
        //Get product SKU stock info
        PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo(product.getId());
        List<PmsSkuStock> skuStockList = skuStockMapper.selectByExample(skuStockExample);
        result.setSkuStockList(skuStockList);
        //Product ladder price set
        if(product.getPromotionType() ==2) {
            PmsProductLadderExample ladderExample = new PmsProductLadderExample();
            ladderExample.createCriteria().andProductIdEqualTo(product.getId());
            List<PmsProductLadder> productLadderList = productLadderMapper.selectByExample(ladderExample);
            result.setProductLadderList(productLadderList);
        }
        //Full reduction
        if(product.getPromotionType()==4){
            PmsProductFullReductionExample fullReductionExample = new PmsProductFullReductionExample();
            fullReductionExample.createCriteria().andProductIdEqualTo(product.getId());
            List<PmsProductFullReduction> productFullReductionList = productFullReductionMapper.selectByExample(fullReductionExample);
            result.setProductFullReductionList(productFullReductionList);
        }
        //Product available coupon
        result.setCouponList(portalProductDao.getAvailableCouponList(product.getId(),product.getProductCategoryId()));
        return result;
    }

    /**
     * Default target convert to node
     */
    private PmsProductCategoryNode convert(PmsProductCategory item, List<PmsProductCategory> allList) {
        PmsProductCategoryNode node = new PmsProductCategoryNode();
        BeanUtils.copyProperties(item,node);
        List<PmsProductCategoryNode> children = allList.stream()
                .filter(subItem ->subItem.getParentId().equals(item.getId()))
                .map(subItem -> convert(subItem,allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}