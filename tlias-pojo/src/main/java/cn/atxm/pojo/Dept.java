package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 * 部门
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;// 主键
    private String name;// 部门名称
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
}
