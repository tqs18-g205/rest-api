package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ClienteTest {

  @Test
  public void creation() {
    Cliente cli = new Cliente(1, "John Doe", "1223", "999999999", "john@doe.com");
    Assertions.assertThat(cli.getId()).isNotZero();
    Assertions.assertThat(cli.getNome()).isEqualTo("John Doe");
    Assertions.assertThat(cli.getPasswd()).isEqualTo("1223");
    Assertions.assertThat(cli.getNif()).isEqualTo("999999999");
    Assertions.assertThat(cli.getEmail()).isEqualTo("john@doe.com");
  }

}
