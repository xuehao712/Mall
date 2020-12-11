package com.shawn.mall.dao;

import com.shawn.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * prodcut and subject relation Dao
 */
public interface CmsSubjectProductRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
