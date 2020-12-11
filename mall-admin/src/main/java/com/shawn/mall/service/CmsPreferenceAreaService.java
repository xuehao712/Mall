package com.shawn.mall.service;

import com.shawn.mall.model.CmsPreferenceArea;

import java.util.List;

/**
 * preference service
 */
public interface CmsPreferenceAreaService {
    /**
     * Get all preference
     */
    List<CmsPreferenceArea> listAll();
}
