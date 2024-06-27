package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.RecruitmentProcessMapper;
import org.du3.ccisp.pojo.RecruitmentProcess;
import org.du3.ccisp.service.RecruitmentProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@Service
public class RecruitmentProcessServiceImpl implements RecruitmentProcessService {
    @Autowired
    private RecruitmentProcessMapper recruitmentProcessMapper;

    @Override
    public List<RecruitmentProcess> queryByGraduateId(int graduateId) {
        return recruitmentProcessMapper.queryByGraduateId(graduateId);
    }

    @Override
    public List<RecruitmentProcess> queryByEnId(int enId) {
        return recruitmentProcessMapper.queryByEnId(enId);
    }

    @Override
    public RecruitmentProcess queryByRpId(int rpId) {
        return recruitmentProcessMapper.queryByRpId(rpId);
    }

    @Override
    public void add(RecruitmentProcess recruitmentProcess) {
        recruitmentProcessMapper.add(recruitmentProcess);
    }

    @Override
    public List<RecruitmentProcess> queryAll() {
        return recruitmentProcessMapper.queryAll();
    }

    @Override
    public void update(RecruitmentProcess recruitmentProcess) {
        recruitmentProcessMapper.update(recruitmentProcess);
    }
}
