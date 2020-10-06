package com.shawn.mall.demo.service;

import com.shawn.mall.demo.dto.PmsBrandDto;
import com.shawn.mall.model.PmsBrand;

import java.util.List;

/**
 * DemoService Api
 */
public interface DemoService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrandDto pmsBrandDto);

    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
