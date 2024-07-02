package org.du3.ccisp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用@Data自动生成需要的get、set
@Data
//使用@AllArgsConstructor自动生成有参构造
@AllArgsConstructor
//使用@NoArgsConstructor自动生成无参构造
@NoArgsConstructor
public class RecruitmentProcess {
    private Integer rpId;
    private String rpPhase;
    private Integer graduateId;
    private Integer enId;
    private String rpCheck;
    private String rpFaceLocation;
    private String rpWorkFile;
    private String rpLnglat;
}
