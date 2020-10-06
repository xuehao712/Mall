package com.shawn.mall.service;

import com.shawn.mall.model.OmsOrderSetting;

/**
 * order setting Service
 * Created by macro on 2018/10/16.
 */
public interface OmsOrderSettingService {
    /**
     * Get single order setting
     */
    OmsOrderSetting getItem(Long id);

    /**
     * Modify order setting
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
