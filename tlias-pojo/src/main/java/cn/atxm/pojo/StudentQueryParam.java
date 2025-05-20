package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer degree;
    private Integer clazzId;
}
