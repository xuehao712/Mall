package com.shawn.mall.service;

import com.shawn.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * order return reason Service
 */
public interface OmsOrderReturnReasonService {
    /**
     * Add order reason
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * Modify return reason
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * Multiple delete reasons
     */
    int delete(List<Long> ids);

    /**
     * Paging get reason lists
     */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * Multiple modify return reason
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * Get single return reason detail
     */
    OmsOrderReturnReason getItem(Long id);
}
