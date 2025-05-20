package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/2
 * 员工
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id; //员工id
    private String username; //用户名
    private String password = "123456"; // 密码
    private String name;//姓名
    private Integer gender;//性别
    private String phone;//电话
    private Integer job;//职位
    private Integer salary;//薪资
    private String image;//头像
    private LocalDate entryDate;//入职日期
    private Integer deptId;//部门id
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
    //部门名称
    private String deptName;
    //员工经历
    private List<EmpExpr> exprList;

}
