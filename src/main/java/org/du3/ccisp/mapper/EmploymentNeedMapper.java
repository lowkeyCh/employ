package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.EmploymentNeed;
import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmploymentNeedMapper {
    /**已使用
     * 增加一条数据
     * @param employmentNeed 数据
     */
    void add(EmploymentNeed employmentNeed);

    /**
     * 从数据苦衷查询所有元素
     * @return
     */
    List<EmploymentNeed> queryAll();

    /**
     * 根据enId查询用用人需求
     * @param enId
     * @return
     */
    EmploymentNeed queryByEnId(int enId);

    /**
     * 根据企业id查询所有的用人需求
     * @param enterpriseId
     * @return
     */
    List<EmploymentNeed> queryByEnterpriseId(int enterpriseId);
}
