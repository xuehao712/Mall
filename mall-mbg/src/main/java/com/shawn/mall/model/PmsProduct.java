package com.shawn.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PmsProduct implements Serializable {
    private Long id;

    private Long brandId;

    private Long productCategoryId;

    private Long freightTemplateId;

    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    @ApiModelProperty(value = "product number")
    private String productSn;

    @ApiModelProperty(value = "delete status：0->no；1->yes")
    private Integer deleteStatus;

    @ApiModelProperty(value = "publish status：0->down；1->up")
    private Integer publishStatus;

    @ApiModelProperty(value = "new status:0->no；1->yes")
    private Integer newStatus;

    @ApiModelProperty(value = "recommend status；0->no；1->yes")
    private Integer recommendStatus;

    @ApiModelProperty(value = "verify status：0->unverified；1->verified")
    private Integer verifyStatus;

    @ApiModelProperty(value = "sort")
    private Integer sort;

    @ApiModelProperty(value = "sale")
    private Integer sale;

    private BigDecimal price;

    @ApiModelProperty(value = "promotion price")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "gift growth")
    private Integer giftGrowth;

    @ApiModelProperty(value = "gift integration")
    private Integer giftPoint;

    @ApiModelProperty(value = "integration use limit")
    private Integer usePointLimit;

    @ApiModelProperty(value = "subtitle")
    private String subTitle;

    @ApiModelProperty(value = "original price")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "stock")
    private Integer stock;

    @ApiModelProperty(value = "low stock")
    private Integer lowStock;

    @ApiModelProperty(value = "unit")
    private String unit;

    @ApiModelProperty(value = "product weight, default pound")
    private BigDecimal weight;

    @ApiModelProperty(value = "whether pcomment product：0->no；1->yes")
    private Integer commentStatus;

    @ApiModelProperty(value = "product service id, separate with comma：1->free return；2->refund；3->free shipping")
    private String serviceIds;

    private String keywords;

    private String note;

    @ApiModelProperty(value = "album pictures, limit 5, separate with comma")
    private String albumPics;

    private String detailTitle;

    @ApiModelProperty(value = "promotion start time")
    private Date promotionStartTime;

    @ApiModelProperty(value = "promotion end time")
    private Date promotionEndTime;

    @ApiModelProperty(value = "promotion limit buying")
    private Integer promotionPerLimit;

    @ApiModelProperty(value = "promotion type：0->original price;1->promotion price；2->member price；3->differential pricing；4->full reduction；5->limit time")
    private Integer promotionType;

    @ApiModelProperty(value = "brand name")
    private String brandName;

    @ApiModelProperty(value = "product category name")
    private String productCategoryName;

    @ApiModelProperty(value = "productdescription")
    private String description;

    private String detailDesc;

    @ApiModelProperty(value = "product detail in html")
    private String detailHtml;

    @ApiModelProperty(value = "product detail in app html")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getFreightTemplateId() {
        return freightTemplateId;
    }

    public void setFreightTemplateId(Long freightTemplateId) {
        this.freightTemplateId = freightTemplateId;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getUsePointLimit() {
        return usePointLimit;
    }

    public void setUsePointLimit(Integer usePointLimit) {
        this.usePointLimit = usePointLimit;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", freightTemplateId=").append(freightTemplateId);
        sb.append(", productAttributeCategoryId=").append(productAttributeCategoryId);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", productSn=").append(productSn);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", newStatus=").append(newStatus);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", sort=").append(sort);
        sb.append(", sale=").append(sale);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", giftGrowth=").append(giftGrowth);
        sb.append(", giftPoint=").append(giftPoint);
        sb.append(", usePointLimit=").append(usePointLimit);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", unit=").append(unit);
        sb.append(", weight=").append(weight);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", serviceIds=").append(serviceIds);
        sb.append(", keywords=").append(keywords);
        sb.append(", note=").append(note);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", detailTitle=").append(detailTitle);
        sb.append(", promotionStartTime=").append(promotionStartTime);
        sb.append(", promotionEndTime=").append(promotionEndTime);
        sb.append(", promotionPerLimit=").append(promotionPerLimit);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", brandName=").append(brandName);
        sb.append(", productCategoryName=").append(productCategoryName);
        sb.append(", description=").append(description);
        sb.append(", detailDesc=").append(detailDesc);
        sb.append(", detailHtml=").append(detailHtml);
        sb.append(", detailMobileHtml=").append(detailMobileHtml);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}