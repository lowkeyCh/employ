package org.du3.ccisp.service;

import org.du3.ccisp.pojo.GraduateQualifications;

import java.util.List;

public interface GraduateQualificationsService {
    List<GraduateQualifications> queryByGraduateId(int graduateId);

    void add(GraduateQualifications graduateQualifications);

    void deleteByGqIndex(String gqIndex);
}
