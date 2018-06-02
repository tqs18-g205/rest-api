package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RestauranteTest {

  @Test
  public void create() {

    TipoCozinha tc = new TipoCozinha(1, "Italiano");
    Restaurante r = new Restaurante(1, "Moliceiro", tc);

    Assertions.assertThat(r.getId()).isNotNull();
    Assertions.assertThat(r.getId()).isEqualTo(1);
    Assertions.assertThat(r.getNome()).isNotNull();
    Assertions.assertThat(r.getNome()).isEqualTo("Moliceiro");
    Assertions.assertThat(r.getTipoCozinha()).isNotNull();
    Assertions.assertThat(r.getTipoCozinha()).isEqualTo(tc);

    Assertions.assertThat(r.getPratos()).isNotNull();
    Assertions.assertThat(r.getPratos()).isEmpty();
    Assertions.assertThat(r.getReservas()).isNotNull();
    Assertions.assertThat(r.getReservas()).isEmpty();
    Assertions.assertThat(r.getTiposEntrega()).isNotNull();
    Assertions.assertThat(r.getTiposEntrega()).isEmpty();

  }

}
