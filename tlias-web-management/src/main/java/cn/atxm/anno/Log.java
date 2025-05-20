package cn.atxm.anno;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
