package com.shawn.mall.service.impl;

import com.shawn.mall.mapper.OmsCompanyAddressMapper;
import com.shawn.mall.model.OmsCompanyAddress;
import com.shawn.mall.model.OmsCompanyAddressExample;
import com.shawn.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company address service impl
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
