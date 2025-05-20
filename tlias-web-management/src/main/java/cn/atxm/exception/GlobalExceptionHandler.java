package cn.atxm.exception;

import cn.atxm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("服务器异常",e);
        return Result.error("出错啦,请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyExceptionException(DuplicateKeyException e){
        log.error("服务器异常",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String substring = message.substring(i);
        String[] split = substring.split(" ");
        return Result.error(split[2]+" 已存在");
    }
}
