package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 * 响应前端柱形图参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList; // 职位列表
    private List dataList; // 日期列表
}
