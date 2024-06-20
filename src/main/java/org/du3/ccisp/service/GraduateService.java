package org.du3.ccisp.service;

import org.du3.ccisp.pojo.Graduate;

import java.util.List;

public interface GraduateService {
    Graduate getGraduateByUserId(int userId);

    void modify(Graduate graduate);

    List<Graduate> queryAll();
}
