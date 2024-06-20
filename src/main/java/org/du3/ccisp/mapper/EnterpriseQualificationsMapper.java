package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.EnterpriseQualifications;
import org.du3.ccisp.pojo.GraduateQualifications;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EnterpriseQualificationsMapper {
    /**
     * 根据毕业生id查询毕业生所有毕业资料
     * @param enterpriseId
     * @return
     */
    List<EnterpriseQualifications> queryByEnterpriseId(Integer enterpriseId);

    /**
     * 添加一条EnterpriseQualifications信息
     * @param enterpriseQualifications 添加信息的enterprise_id为enterpriseQualifications.enterpriseId
     */
    void add(EnterpriseQualifications enterpriseQualifications);

    /**
     * 通过gqIndex删除数据库中当前元素
     * @param eqIndex
     */
    void deleteByEqIndex(String eqIndex);
}
