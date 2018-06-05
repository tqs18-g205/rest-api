package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EstadoEncomendaTest {

  @Test
  public void create() {
    EstadoEncomenda ee = new EstadoEncomenda(1, "Em preparação");
    Assertions.assertThat(ee.getId()).isEqualTo(1);
    Assertions.assertThat(ee.getDescricao()).isEqualTo("Em preparação");
    Assertions.assertThat(ee.getEncomendas()).isNotNull();
    Assertions.assertThat(ee.getEncomendas()).isEmpty();
  }

}
