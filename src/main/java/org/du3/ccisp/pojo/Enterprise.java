package org.du3.ccisp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//使用@Data自动生成需要的get、set
@Data
//使用@AllArgsConstructor自动生成有参构造
@AllArgsConstructor
//使用@NoArgsConstructor自动生成无参构造
@NoArgsConstructor
public class Enterprise {
    private Integer enterpriseId;
    private String enterpriseName;
    private String enterpriseRegistrationPlace;
    private String enterpriseRegisteredCapital;
    private String enterpriseLegalRepresentative;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date enterpriseFoundingDate;
    private String enterpriseEmail;
    private String enterpriseCoreBusiness;
    private Integer userId;
    private String enterpriseQualificationsCheck;
}
