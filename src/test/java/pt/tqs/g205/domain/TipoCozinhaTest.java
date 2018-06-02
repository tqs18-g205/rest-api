package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TipoCozinhaTest {

  @Test
  public void create() {

    TipoCozinha tp = new TipoCozinha(1, "Mediterrânea");

    Assertions.assertThat(tp.getId()).isNotNull();
    Assertions.assertThat(tp.getId()).isEqualTo(1);
    Assertions.assertThat(tp.getNome()).isNotBlank();
    Assertions.assertThat(tp.getNome()).isEqualTo("Mediterrânea");

  }

}
