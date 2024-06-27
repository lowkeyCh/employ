package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.EmploymentNeedMapper;
import org.du3.ccisp.pojo.EmploymentNeed;
import org.du3.ccisp.service.EmploymentNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmploymentNeedServiceImpl implements EmploymentNeedService {
    @Autowired
    private EmploymentNeedMapper employmentNeedMapper;

    @Override
    public void add(EmploymentNeed employmentNeed) {
        employmentNeedMapper.add(employmentNeed);
    }

    @Override
    public List<EmploymentNeed> queryAll() {
        return employmentNeedMapper.queryAll();
    }

    @Override
    public EmploymentNeed queryByEnId(int enId) {
        return employmentNeedMapper.queryByEnId(enId);
    }

    @Override
    public List<EmploymentNeed> queryByEnterpriseId(int enterpriseId) {
        return employmentNeedMapper.queryByEnterpriseId(enterpriseId);
    }
}
