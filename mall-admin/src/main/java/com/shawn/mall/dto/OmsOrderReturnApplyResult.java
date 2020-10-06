package com.shawn.mall.dto;

import com.shawn.mall.model.OmsCompanyAddress;
import com.shawn.mall.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Apply info
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "Company address")
    private OmsCompanyAddress companyAddress;
}
