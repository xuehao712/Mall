package com.shawn.mall.service;

import com.shawn.mall.model.SmsHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Subject recommend service
 */
public interface SmsHomeRecommendSubjectService {
    /**
     * Create
     */
    @Transactional
    int create(List<SmsHomeRecommendSubject> recommendSubjectList);

    /**
     * Modify sorting
     */
    int updateSort(Long id, Integer sort);

    /**
     * Multiple delete
     */
    int delete(List<Long> ids);

    /**
     * Update status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paging search
     */
    List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
