package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 * 员工经历
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    private Integer id;//员工经历id
    private Integer empId;//员工id
    private LocalDate begin;//入职时间
    private LocalDate end;//离职时间
    private String company;//公司
    private String job;//职位
}
