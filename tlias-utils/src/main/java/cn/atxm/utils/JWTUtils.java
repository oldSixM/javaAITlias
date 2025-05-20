package cn.atxm.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */
public class JWTUtils {
    private static final String SECRET = "eGh0ZG14";

    /**
     * 生成JWT令牌
     * @param claims 需要包含在令牌中的声明
     * @return 生成的JWT字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setClaims(claims)
                .setExpiration(expirationDate)
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param token 需要解析的JWT字符串
     * @return 解析后的声明对象
     * @throws JwtException 如果令牌无效或签名错误
     */
    public static Map<String, Object> parseToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
