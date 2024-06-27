package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.GraduateMapper;
import org.du3.ccisp.mapper.UserMapper;
import org.du3.ccisp.pojo.Graduate;
import org.du3.ccisp.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateServiceImpl implements GraduateService {
    @Autowired
    private GraduateMapper graduateMapper;

    @Override
    public void modify(Graduate graduate) {
        graduateMapper.modify(graduate);
    }

    @Override
    public Graduate getGraduateByUserId(int userId) {
        return graduateMapper.getGraduateByUserId(userId);
    }

    @Override
    public List<Graduate> queryAll() {
        return graduateMapper.queryAll();
    }

    @Override
    public Graduate queryByGraduateId(int graduateId) {
        return graduateMapper.queryByGraduateId(graduateId);
    }
}
