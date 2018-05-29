package pt.tqs.g205.security;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUtilTest {
  @Autowired
  private JwtUtil jwtUtil;

  private String username;

  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    username = "john@doe.com";
  }

  @Test
  public void generateToken() {
    String token = jwtUtil.generateToken(username);

    Assertions.assertThat(token).isNotNull();
    Assertions.assertThat(token).isNotBlank();
    Assertions.assertThat(token).isNotEqualTo(username);
  }

  @Test
  public void validToken() {
    String token = jwtUtil.generateToken(username);

    boolean valid = jwtUtil.validToken(token);

    Assertions.assertThat(valid).isTrue();
  }

  @Test
  public void invalidToken() {
    String token = "12a3";

    boolean valid = jwtUtil.validToken(token);

    Assertions.assertThat(valid).isFalse();
  }


  @Test
  public void getUsername() {
    String token = jwtUtil.generateToken(username);

    String user = jwtUtil.getUsername(token);

    Assertions.assertThat(user).isNotNull();
    Assertions.assertThat(user).isNotBlank();
    Assertions.assertThat(user).isEqualTo(username);
  }
}
