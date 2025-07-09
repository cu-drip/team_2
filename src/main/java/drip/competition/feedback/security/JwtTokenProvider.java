package drip.competition.feedback.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretFile;

    private Key key;

    @PostConstruct
    public void init() {
        try {
            byte[] secretBytes = Files.readAllBytes(Path.of(secretFile));
            this.key = Keys.hmacShaKeyFor(secretBytes);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать секретный ключ для JWT", e);
        }
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isTokenExpired(String token) {
        return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    public List<String> getRolesFromToken(String token) {
        return (List<String>) getAllClaimsFromToken(token).get("roles");
    }
}
