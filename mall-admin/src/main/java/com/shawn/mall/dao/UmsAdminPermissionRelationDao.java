package com.shawn.mall.dao;

import com.shawn.mall.model.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * member permission relation Dao
 */
public interface UmsAdminPermissionRelationDao {
    /**
     * Multiple create
     */
    int insertList(@Param("list") List<UmsAdminPermissionRelation> list);
}
