package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 * 学生
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;// 主键
    private String name;// 姓名
    private String no;// 学号
    private Integer gender;// 性别
    private String phone;//手机号
    private String idCard;//身份证号
    private Integer isCollege;//是否来自于院校, 1:是, 0:否
    private String address;//联系地址
    private Integer degree;//最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士
    private LocalDate graduationDate;//毕业时间
    private Integer clazzId;//班级ID, 关联班级表ID
    private String clazzName;//班级名称
    private Integer violationCount;//违纪次数
    private Integer violationScore;//违纪扣分
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
