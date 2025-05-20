package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id;
    private String username;
    private String name;
    private String token;
}
