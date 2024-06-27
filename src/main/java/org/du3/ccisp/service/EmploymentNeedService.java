package org.du3.ccisp.service;

import org.du3.ccisp.pojo.EmploymentNeed;
import org.du3.ccisp.pojo.Enterprise;

import java.util.List;

public interface EmploymentNeedService {
    void add(EmploymentNeed employmentNeed);

    List<EmploymentNeed> queryAll();

    EmploymentNeed queryByEnId(int enId);

    List<EmploymentNeed> queryByEnterpriseId(int enterpriseId);
}
