package org.du3.ccisp.service;

import org.du3.ccisp.pojo.Quarters;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuartersService {
    List<Quarters> queryAll();

    Quarters queryByQuartersId(int quartersId);

    void add(Quarters quarters);
}
