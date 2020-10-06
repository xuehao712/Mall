package com.shawn.mall.service.impl;

import com.shawn.mall.mapper.CmsPreferenceAreaMapper;
import com.shawn.mall.model.CmsPreferenceArea;
import com.shawn.mall.model.CmsPreferenceAreaExample;
import com.shawn.mall.service.CmsPreferenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * product preference service impl
 */
@Service
public class CmsPreferenceAreaServiceImpl implements CmsPreferenceAreaService {
    @Autowired
    private CmsPreferenceAreaMapper preferenceAreaMapper;

    @Override
    public List<CmsPreferenceArea> listAll() {
        return preferenceAreaMapper.selectByExample(new CmsPreferenceAreaExample());
    }
}
