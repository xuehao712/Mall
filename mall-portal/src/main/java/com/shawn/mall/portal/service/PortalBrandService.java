package com.shawn.mall.portal.service;

import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.model.PmsBrand;
import com.shawn.mall.model.PmsProduct;

import java.util.List;

/**
 * Front end brand service
 */
public interface PortalBrandService {
    /**
     * Get recommend brand list
     */
    List<PmsBrand> recommendList(Integer pageNum,Integer pageSize);

    /**
     * Get brand detail
     */
    PmsBrand detail(Long brandId);

    /**
     * Brand related product list
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum,Integer pageSize);
}
