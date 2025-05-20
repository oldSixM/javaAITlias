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
 * 班级
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id;// 主键
    private String name;// 班级名称
    private String room;// 教室
    private LocalDate beginDate;// 开课时间
    private LocalDate endDate;// 结课时间
    private Integer masterId;//班主任ID, 关联员工表ID
    private Integer subject;// 科目
    private String masterName;// 班主任姓名
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private String status; // 状态, 未开班、已结课、在读中
}
