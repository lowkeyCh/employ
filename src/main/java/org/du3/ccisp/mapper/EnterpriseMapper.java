package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.pojo.Graduate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EnterpriseMapper {
    /**
     * 根据用户id查询毕业生基本信息
     * @param userId 用户id
     * @return Enterprise 毕业生类
     */
    Enterprise getEnterpriseByUserId(int userId);

    /**
     * 修改enterprise的信息 根据所传对象的enterpriseId
     * @param enterprise
     */
    void modify(Enterprise enterprise);

    /**
     * 从数据苦衷查询所有元素
     * @return
     */
    List<Enterprise> queryAll();
}
