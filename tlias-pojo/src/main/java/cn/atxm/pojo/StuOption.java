package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuOption {
    private List clazzList;
    private List dataList;
}
