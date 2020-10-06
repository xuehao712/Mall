package com.shawn.mall.dao;

import com.shawn.mall.dto.OmsOrderReturnApplyResult;
import com.shawn.mall.dto.OmsReturnApplyQueryParam;
import com.shawn.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * order return apply Dao
 */
public interface OmsOrderReturnApplyDao {
    /**
     * Search application list
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * Ger application detail
     */
    OmsOrderReturnApplyResult getDetail(@Param("id") Long id);
}
