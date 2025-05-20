package cn.atxm.interceptor;

import cn.atxm.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();


        String token = request.getHeader("Token");

        if (token==null || token.isEmpty()) {
            log.info("未登录，请先登录401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        try {
            JWTUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token错误");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        log.info("成功");
        return true;
    }
}
