package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.Graduate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GraduateMapper {
    /**
     * 根据用户id查询毕业生基本信息
     * @param userId 用户id
     * @return Graduate 毕业生类
     */
    Graduate getGraduateByUserId(int userId);

    /**
     * 修改graduate的信息 根据所传对象的graduateId
     * @param graduate
     */
    void modify(Graduate graduate);

    /**
     * 查询所有毕业生并返回集合
     * @return
     */
    public List<Graduate> queryAll();
}
