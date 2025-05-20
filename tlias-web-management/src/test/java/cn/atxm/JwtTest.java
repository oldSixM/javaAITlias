package cn.atxm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/11
 */

public class JwtTest {

    @Test
    public void testGennerateToken(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","admin");
        claims.put("password","123456");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "eGh0ZG14")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImlkIjoxLCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzQ0MzM4NzEzfQ.50wPGu8Q5gknvad1mgXx-Y7uPYbgZgx8oBQ0IXoNv24";
        Claims claims = Jwts.parser()
                .setSigningKey("eGh0ZG14")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);

    }
}
