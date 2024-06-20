package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.GraduateQualificationsMapper;
import org.du3.ccisp.pojo.GraduateQualifications;
import org.du3.ccisp.service.GraduateQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GraduateQualificationsServiceImpl implements GraduateQualificationsService {
    @Autowired
    private GraduateQualificationsMapper graduateQualificationsMapper;

    @Override
    public List<GraduateQualifications> queryByGraduateId(int graduateId) {
        return graduateQualificationsMapper.queryByGraduateId(graduateId);
    }

    @Override
    public void deleteByGqIndex(String gqIndex) {
        graduateQualificationsMapper.deleteByGqIndex(gqIndex);
    }

    @Override
    public void add(GraduateQualifications graduateQualifications) {
        graduateQualificationsMapper.add(graduateQualifications);
    }
}
