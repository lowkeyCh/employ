package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.RecruitmentProcess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecruitmentProcessMapper {
    /**
     * 增加一条数据
     * @param recruitmentProcess
     */
    void add(RecruitmentProcess recruitmentProcess);

    /**
     * 通过graduateId查询招聘情况
     */
    List<RecruitmentProcess> queryByGraduateId(int graduateId);


    /**
     * 根据用人需求查询毕业生信息
     * @param enId
     * @return
     */
    List<RecruitmentProcess> queryByEnId(int enId);

    /**
     * 通过rpId查询招聘情况
     * @param rpId
     * @return
     */
    RecruitmentProcess queryByRpId(int rpId);

    /**
     * 查询所有招聘情况
     * @return
     */
    List<RecruitmentProcess> queryAll();

    /**
     * 更新数据
     * @param recruitmentProcess
     */
    void update(RecruitmentProcess recruitmentProcess);
}
