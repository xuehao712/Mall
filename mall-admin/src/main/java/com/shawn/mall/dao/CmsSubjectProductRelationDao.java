package com.shawn.mall.dao;

import com.shawn.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * prodcut and subject relation Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectProductRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
