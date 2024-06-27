package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.Quarters;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface QuartersMapper {
    List<Quarters> queryAll();
}
