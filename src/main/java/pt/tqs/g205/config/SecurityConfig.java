package pt.tqs.g205.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import pt.tqs.g205.security.JwtAuthenticationFilter;
import pt.tqs.g205.security.JwtAuthorizationFilter;
import pt.tqs.g205.security.JwtUtil;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private Environment env;

  @Autowired
  private JwtUtil jwtUtil;

  private static final String[] PUBLIC_MATCHERS = {"/h2-console/**"};

  private static final String[] PUBLIC_MATCHERS_GET =
      {"/api/pratos/**", "/api/categorias/**", "/api/ingredientes/**",
          "/api/restaurantes/**", "/api/tiposentrega/**",
          "/api/tiposcozinha/**"};

  private static final String[] PUBLIC_MATCHERS_POST = {"/api/clientes"};

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
      http.headers().frameOptions().disable();
    }

    http.cors().and().csrf().disable();
    http.authorizeRequests().antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
        .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().antMatchers(PUBLIC_MATCHERS)
        .permitAll().anyRequest().authenticated();
    http.addFilter(
        new JwtAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
    http.addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtUtil));
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(beCryptPasswordEncoder());
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }

  @Bean
  public BCryptPasswordEncoder beCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
