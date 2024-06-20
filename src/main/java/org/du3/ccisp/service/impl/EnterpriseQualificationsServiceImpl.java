package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.EnterpriseQualificationsMapper;
import org.du3.ccisp.pojo.EnterpriseQualifications;
import org.du3.ccisp.service.EnterpriseQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EnterpriseQualificationsServiceImpl implements EnterpriseQualificationsService {
    @Autowired
    private EnterpriseQualificationsMapper enterpriseQualificationsMapper;

    @Override
    public List<EnterpriseQualifications> queryByEnterpriseId(int enterpriseId) {
        return enterpriseQualificationsMapper.queryByEnterpriseId(enterpriseId);
    }

    @Override
    public void add(EnterpriseQualifications enterpriseQualifications) {
        enterpriseQualificationsMapper.add(enterpriseQualifications);
    }

    @Override
    public void deleteByEqIndex(String eqIndex) {
        enterpriseQualificationsMapper.deleteByEqIndex(eqIndex);
    }
}
