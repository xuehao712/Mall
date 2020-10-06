package com.shawn.mall.service;

import com.shawn.mall.model.CmsPreferenceArea;

import java.util.List;

/**
 * preference service
 * Created by macro on 2018/6/1.
 */
public interface CmsPreferenceAreaService {
    /**
     * Get all preference
     */
    List<CmsPreferenceArea> listAll();
}
