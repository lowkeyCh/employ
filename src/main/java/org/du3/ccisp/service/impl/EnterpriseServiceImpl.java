package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.EnterpriseMapper;
import org.du3.ccisp.mapper.GraduateMapper;
import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> queryAll() {
        return enterpriseMapper.queryAll();
    }

    @Override
    public Enterprise getEnterpriseByUserId(int userId) {
        return enterpriseMapper.getEnterpriseByUserId(userId);
    }

    @Override
    public void modify(Enterprise enterprise) {
        enterpriseMapper.modify(enterprise);
    }
}
