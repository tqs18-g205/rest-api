package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RestauranteTest {

  @Test
  public void create() {

    TipoCozinha tc = new TipoCozinha(1, "Italiano");
    Restaurante res = new Restaurante(1, "Moliceiro", tc);

    Assertions.assertThat(res.getId()).isNotNull();
    Assertions.assertThat(res.getId()).isEqualTo(1);
    Assertions.assertThat(res.getNome()).isNotNull();
    Assertions.assertThat(res.getNome()).isEqualTo("Moliceiro");
    Assertions.assertThat(res.getTipoCozinha()).isNotNull();
    Assertions.assertThat(res.getTipoCozinha()).isEqualTo(tc);

    Assertions.assertThat(res.getPratos()).isNotNull();
    Assertions.assertThat(res.getPratos()).isEmpty();
    Assertions.assertThat(res.getReservas()).isNotNull();
    Assertions.assertThat(res.getReservas()).isEmpty();
    Assertions.assertThat(res.getTiposEntrega()).isNotNull();
    Assertions.assertThat(res.getTiposEntrega()).isEmpty();

  }

}
