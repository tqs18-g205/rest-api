package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class TipoEntregaTest {

  @Test
  public void create() {

    TipoEntrega te = new TipoEntrega(1, "TakeAway");

    Assertions.assertThat(te.getId()).isNotNull();
    Assertions.assertThat(te.getId()).isEqualTo(1);
    Assertions.assertThat(te.getDescricao()).isNotBlank();
    Assertions.assertThat(te.getDescricao()).isEqualTo("TakeAway");

  }

}
