package cn.atxm.filter;

import cn.atxm.utils.CurrentHolder;
import cn.atxm.utils.JWTUtils;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */
@WebFilter("/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求路径
        String uri = request.getRequestURI();

        //2.判断是否是登录请求
        if (uri.contains("/login")){
            log.info("登录请求，放行");
            filterChain.doFilter(request,response);
            return;
        }

        //3.获取token
        String token = request.getHeader("Token");

        //5.判断token为空
        if (token == null || token.isEmpty()){
            log.info("未登录，请先登录");
            response.setStatus(401);
            return;
        }

        //6.判断token是否正确
        try {
            Map<String, Object> t = JWTUtils.parseToken(token);
            CurrentHolder.setCurrentId(Integer.valueOf(t.get("id").toString()));
        } catch (JwtException e) {
            log.info("token错误");
            response.setStatus(401);
            return;
        }

        //7.放行
        filterChain.doFilter(request,response);


        CurrentHolder.remove();
    }
}
