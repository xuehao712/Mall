package com.shawn.mall.search.repository;

import com.shawn.mall.search.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Product Es repository
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /**
     *
     * @param name
     * @param subTitle
     * @param keywords
     * @param page
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
