package com.shawn.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.shawn.mall.common.api.CommonPage;
import com.shawn.mall.mapper.PmsBrandMapper;
import com.shawn.mall.mapper.PmsProductMapper;
import com.shawn.mall.model.PmsBrand;
import com.shawn.mall.model.PmsProduct;
import com.shawn.mall.model.PmsProductExample;
import com.shawn.mall.portal.dao.HomeDao;
import com.shawn.mall.portal.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Front end brand service impl
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum,Integer pageSize) {
        int off = (pageNum-1)*pageSize;
        return homeDao.getRecommendBrandList(off,pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
