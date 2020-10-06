package com.shawn.mall.dao;

import com.shawn.mall.model.CmsPreferenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Relation between preference and product Dao
 */
public interface CmsPreferenceAreaProductRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<CmsPreferenceAreaProductRelation> preferenceAreaProductRelationList);
}
