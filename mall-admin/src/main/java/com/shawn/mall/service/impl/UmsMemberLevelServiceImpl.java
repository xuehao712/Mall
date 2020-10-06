package com.shawn.mall.service.impl;

import com.shawn.mall.mapper.UmsMemberLevelMapper;
import com.shawn.mall.model.UmsMemberLevel;
import com.shawn.mall.model.UmsMemberLevelExample;
import com.shawn.mall.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * member level Service impl
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
