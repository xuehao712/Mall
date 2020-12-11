package com.shawn.mall.service;

import com.shawn.mall.model.CmsSubject;
import java.util.List;

/**
 * Product subject Service
 */
public interface CmsSubjectService {
    /**
     * Search all subject
     */
    List<CmsSubject> listAll();

    /**
     * Paging search subject
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}
