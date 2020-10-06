package com.shawn.mall.dto;

import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * flash promotion
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{
    @Getter
    @Setter
    @ApiModelProperty("related product")
    private PmsProduct product;
}
