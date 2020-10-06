package com.shawn.mall.service;

import com.shawn.mall.model.CmsSubject;
import java.util.List;

/**
 * Product subject Service
 * Created by macro on 2018/6/1.
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
