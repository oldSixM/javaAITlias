package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/3
 * 响应前端分页参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T>{
    private Long total; //总记录数
    private List<T> rows; //当前页数据
}
