package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EstadoEncomendaHoraPkTest {

  @Test
  public void create() {
    EstadoEncomendaHoraPk eehPk = new EstadoEncomendaHoraPk(1, 2);
    Assertions.assertThat(eehPk.getEncomenda()).isEqualTo(1);
    Assertions.assertThat(eehPk.getEstado()).isEqualTo(2);

  }

}
