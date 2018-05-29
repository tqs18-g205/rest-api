package pt.tqs.g205.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component
public class JwtUtil {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private Long expiration;
  
  /**
   * Gera um token a partir do email do utilizador.
   * @param username email do utilizador.
   * @return token.
   */
  public String generateToken(String username) {
    return Jwts.builder().setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
  }
  
  /**
   * Verifica se o token passado é válido.
   * @param token token.
   * @return verdadeiro se token for válido.
   */
  public boolean validToken(String token) {
    Claims claims = getClaims(token);
    if (claims != null) {
      String username = claims.getSubject();
      Date expirationDate = claims.getExpiration();
      Date now = new Date(System.currentTimeMillis());
      if (username != null && expirationDate != null && now.before(expirationDate)) {
        return true;
      }

    }
    return false;
  }

  private Claims getClaims(String token) {
    try {
      return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
    } catch (Exception exc) {
      return null;
    }
  }

  /**
   * Restaura username a partir de token.
   * @param token token.
   * @return email do user.
   */
  public String getUsername(String token) {
    Claims claims = getClaims(token);
    if (claims != null) {
      return claims.getSubject();
    }
    return null;
  }

}
