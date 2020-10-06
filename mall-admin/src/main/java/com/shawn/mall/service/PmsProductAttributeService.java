package com.shawn.mall.service;

import com.shawn.mall.dto.PmsProductAttributeParam;
import com.shawn.mall.dto.ProductAttrInfo;
import com.shawn.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product attribute Service
 */
public interface PmsProductAttributeService {
    /**
     * Get product attributes list
     * @param cid category id
     * @param type 0->attribute；2->params
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * Add
     */
    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    /**
     * Modify
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * Get single detail
     */
    PmsProductAttribute getItem(Long id);

    /**
     * Delete
     */
    @Transactional
    int delete(List<Long> ids);

    /**
     * Get product attribute info
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
