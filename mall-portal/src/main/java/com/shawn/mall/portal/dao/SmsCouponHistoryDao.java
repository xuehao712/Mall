package com.shawn.mall.portal.dao;

import com.shawn.mall.model.SmsCoupon;
import com.shawn.mall.portal.domain.SmsCouponHistoryDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Member coupon receive history
 */
public interface SmsCouponHistoryDao {
    /**
     * Get coupon history detail
     */
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    /**
     * Get member coupon list
     */
    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus") Integer useStatus);

}
