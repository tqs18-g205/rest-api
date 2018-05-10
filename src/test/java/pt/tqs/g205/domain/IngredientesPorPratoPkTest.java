package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IngredientesPorPratoPkTest {

  @Test
  public void creation() {
    IngredientesPorPratoPk pk = new IngredientesPorPratoPk(1, 3);

    Assertions.assertThat(pk.getPratoId()).isEqualTo(1);
    Assertions.assertThat(pk.getIngredienteId()).isEqualTo(3);
  }
}
