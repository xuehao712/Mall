package com.shawn.mall.service;

import com.shawn.mall.dto.OmsOrderReturnApplyResult;
import com.shawn.mall.dto.OmsReturnApplyQueryParam;
import com.shawn.mall.dto.OmsUpdateStatusParam;
import com.shawn.mall.model.OmsOrderReturnApply;

import java.util.List;

/**
 * Return apply service
 */
public interface OmsOrderReturnApplyService {
    /**
     * Paging search application
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * Multiple application delete
     */
    int delete(List<Long> ids);

    /**
     * Modify return status
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * Get application detail
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
