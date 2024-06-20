package org.du3.ccisp.service;

import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.pojo.Graduate;

import java.util.List;

public interface EnterpriseService {
    Enterprise getEnterpriseByUserId(int userId);

    void modify(Enterprise enterprise);

    List<Enterprise> queryAll();
}
