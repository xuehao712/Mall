package com.shawn.mall.dto;

import com.shawn.mall.model.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * product quantity flash session
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {
    @Setter
    @Getter
    @ApiModelProperty("product quantity")
    private Long productCount;
}
