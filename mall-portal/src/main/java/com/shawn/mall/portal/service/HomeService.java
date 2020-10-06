package com.shawn.mall.portal.service;

import com.shawn.mall.model.CmsSubject;
import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.model.PmsProductCategory;
import com.shawn.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * Home page content manage service
 */
public interface HomeService {

    /**
     * Get home page content
     */
    HomeContentResult content();

    /**
     * Home page product recommend
     */
    List<PmsProduct> recommendProductList(Integer pageSize,Integer pageNum);

    /**
     * Get product category
     * @param parentId 0:first category other: assigned secondary category
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * Get subject base on subject id
     */
    List<CmsSubject> getSubjectList(Long cateId,Integer pageSize, Integer pageNum);

    /**
     * Get hot product
     */
    List<PmsProduct> hotProductList(Integer pageSize,Integer pageNum);

    /**
     * Get new product
     */
    List<PmsProduct> newProductList(Integer pageSize,Integer pageNum);
}
