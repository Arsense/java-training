package com.base.demo.webgoart;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

/**
 * @author tangwei
 * @date 2019/8/13 10:44
 */
public class JWTToken {

        public static final String JWT_PASSWORD = TextCodec.BASE64.encode("victory");

        public static void createJWTToken() {
            Claims claims = Jwts.claims().setIssuedAt(Date.from(Instant.now().plus(Duration.ofDays(10))));
            claims.put("admin", "true");
            claims.put("user", "Tom");
            String token = Jwts.builder().setClaims(claims).signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, JWT_PASSWORD).compact();
            System.out.println(token);
        }
        public static void main(String[] args) {
//            JWTToken.createJWTToken();
            JWTToken.createToken1();
    }


    public static void createToken1() {
//        {"iss":"WebGoat Token Builder","iat":1524210904,"exp":1618905304,"aud":"webgoat.org","sub":"tom@webgoat.com","username":"Tom","Email":"tom@webgoat.com","Role":["Manager","Project Administrator"]}
        Claims claims = Jwts.claims().setIssuedAt(Date.from(Instant.now().plus(Duration.ofDays(10))));
        claims.put("iss", "WebGoat Token Builder");
        claims.put("iat", "1524210904");
        claims.put("exp", "1618905304");
        claims.put("aud", "webgoat.org");
        claims.put("sub", "tom@webgoat.com");
        claims.put("username", "WebGoat");
        claims.put("Email", "tom@webgoat.com");
        claims.put("Role", "[\"Manager\",\"Project Administrator\"]");
        claims.put("userId ", "123");
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, JWT_PASSWORD).compact();
        System.out.println(token);
    }

}
