package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 * 班级分页查询参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private Integer page = 1; // 当前页码
    private Integer pageSize = 10; // 每页条数
    private String name;// 班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;// 范围匹配的开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;// 范围匹配的结束时间
}
