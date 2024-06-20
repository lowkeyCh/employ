package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.GraduateQualifications;
import org.du3.ccisp.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GraduateQualificationsMapper {
    /**
     * 根据毕业生id查询毕业生所有毕业资料
     * @param graduateId
     * @return
     */
    List<GraduateQualifications> queryByGraduateId(Integer graduateId);

    /**
     * 添加一条GraduateQualifications信息
     * @param graduateQualifications 添加信息的graduate_id为graduateQualifications.graduateId
     */
    void add(GraduateQualifications graduateQualifications);

    /**
     * 通过gqIndex删除数据库中当前元素
     * @param gqIndex
     */
    void deleteByGqIndex(String gqIndex);
}
