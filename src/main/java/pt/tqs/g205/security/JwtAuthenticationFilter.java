package pt.tqs.g205.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pt.tqs.g205.dto.CredentialsDto;
import pt.tqs.g205.dto.LoginDto;
import pt.tqs.g205.services.exceptions.AuthorizationException;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;
  private JwtUtil jwtUtil;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }


  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {

    try {
      CredentialsDto creds =
          new ObjectMapper().readValue(req.getInputStream(), CredentialsDto.class);
      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
          creds.getUsername(), creds.getPasswd(), new ArrayList<>());
      return authenticationManager.authenticate(authToken);
    } catch (IOException exc) {
      throw new AuthorizationException("Access Denied");
    }

  }

  @Override
  public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
      FilterChain chain, Authentication auth) throws IOException, ServletException {
    String username = ((ClienteSs) auth.getPrincipal()).getUsername();
    Integer id = ((ClienteSs) auth.getPrincipal()).getId();
    String token = jwtUtil.generateToken(username);
    
    res.addHeader("Authorization", "Bearer " + token);
    LoginDto dto = new LoginDto(id, "Bearer " + token);
    
    res.getWriter().write(new ObjectMapper().writeValueAsString(dto));
  }
}
