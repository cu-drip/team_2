package drip.competition.feedback.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.Map;

public class JwtTokenGenerator {
    public static void main(String[] args) {
        String secret = "MySuperSecretKeyWhichShouldBeLongEnough123456";
        byte[] keyBytes = secret.getBytes();

        String token = Jwts.builder()
            .setSubject("admin123")
            .addClaims(Map.of("role", "ADMIN"))
            .setExpiration(new Date(System.currentTimeMillis() + 3600_000))
            .signWith(Keys.hmacShaKeyFor(keyBytes), SignatureAlgorithm.HS256)
            .compact();

        System.out.println("✅ YOUR VALID TOKEN:");
        System.out.println(token);
    }
}
