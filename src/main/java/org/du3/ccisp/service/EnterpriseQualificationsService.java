package org.du3.ccisp.service;

import org.du3.ccisp.pojo.EnterpriseQualifications;
import org.du3.ccisp.pojo.GraduateQualifications;

import java.util.List;

public interface EnterpriseQualificationsService {
    List<EnterpriseQualifications> queryByEnterpriseId(int enterpriseId);

    void add(EnterpriseQualifications enterpriseQualifications);

    void deleteByEqIndex(String eqIndex);
}
