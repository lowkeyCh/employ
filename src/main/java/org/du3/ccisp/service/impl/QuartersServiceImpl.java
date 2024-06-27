package org.du3.ccisp.service.impl;

import org.du3.ccisp.mapper.QuartersMapper;
import org.du3.ccisp.pojo.Quarters;
import org.du3.ccisp.service.QuartersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuartersServiceImpl implements QuartersService {
    @Autowired
    private QuartersMapper quartersMapper;

    @Override
    public List<Quarters> queryAll() {
        return quartersMapper.queryAll();
    }
}
