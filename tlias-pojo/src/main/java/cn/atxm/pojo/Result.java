package cn.atxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 * 响应前端信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//状态码
    private String msg;//提示信息
    private Object data;//返回数据

    public static Result success(){
        return new Result(1,"success",null);
    }

    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
