package com.shawn.mall.portal.service;

import com.shawn.mall.portal.domain.OmsOrderReturnApplyParam;

/**
 * Front end order return service
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * Apply
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
