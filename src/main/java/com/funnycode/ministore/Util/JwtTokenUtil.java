package com.funnycode.ministore.Util;

import com.funnycode.ministore.Model.TokenPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtTokenUtil {
    @Value("${JWT_SECRET_KEY}")
    private String secret;

    public String generateToken(TokenPayload tokenPayload, long expiredDate){
        Map<String, Object> claims = new HashMap<>();
        claims.put("payload", tokenPayload);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ expiredDate*1000) )
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public TokenPayload getTokenPayload(String token) {
        return getClaimsFromToken(token, (Claims claim) -> {
            Map<String, Object> mapResult = (Map<String, Object>) claim.get("payload");
            return TokenPayload.builder()
                    .accountID((Integer) mapResult.get("accountID"))
                    .username((String) mapResult.get("username"))
                    .build();
        });
    }

    // functional
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public boolean isValid(String token, TokenPayload tokenPayloadFromAccount){
        if (isTokenExpired(token)) {
            return false;
        }
        TokenPayload tokenPayload = getTokenPayload(token);
        return tokenPayload.getAccountID() == tokenPayloadFromAccount.getAccountID()
                && tokenPayload.getUsername().equals(tokenPayloadFromAccount.getUsername());
    }

    private boolean isTokenExpired(String token){
        Date expiredTime = getClaimsFromToken(token, Claims::getExpiration);
        return expiredTime.before(new Date());
    }
}
