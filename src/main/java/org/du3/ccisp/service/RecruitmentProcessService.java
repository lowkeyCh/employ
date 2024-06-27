package org.du3.ccisp.service;

import org.du3.ccisp.pojo.RecruitmentProcess;
import org.du3.ccisp.pojo.User;

import java.util.List;

public interface RecruitmentProcessService {
    void add(RecruitmentProcess recruitmentProcess);

    List<RecruitmentProcess> queryByGraduateId(int graduateId);

    RecruitmentProcess queryByRpId(int rpId);

    List<RecruitmentProcess> queryAll();

    List<RecruitmentProcess> queryByEnId(int enId);

    void update(RecruitmentProcess recruitmentProcess);
}
