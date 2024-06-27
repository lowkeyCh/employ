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
public class Quarters {
    private Integer quartersId;
    private String quartersFirst;
    private String quartersSecond;
    private String quartersThird;
}
