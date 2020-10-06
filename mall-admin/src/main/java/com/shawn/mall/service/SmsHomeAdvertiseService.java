package com.shawn.mall.service;

import com.shawn.mall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * Home advertise Service
 */
public interface SmsHomeAdvertiseService {
    /**
     * Create
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * Multiple delete
     */
    int delete(List<Long> ids);

    /**
     * Modify up or down status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Get advertise detail
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * Modify
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * Paging advertise
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
