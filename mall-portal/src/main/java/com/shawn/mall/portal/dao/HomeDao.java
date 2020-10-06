package com.shawn.mall.portal.dao;

import com.shawn.mall.model.CmsSubject;
import com.shawn.mall.model.PmsBrand;
import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Home page content customize dao
 */
public interface HomeDao {
    /**
     * Get recommend brand
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * Get flash promotion product
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * Get new product
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * Get hot product
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * Get recommend subject
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
