package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoradaTest {

  @Test
  public void creation() {
    Morada morada = new Morada(1, "Rua xpto", "Gloria", "3810-555", "Aveiro", null, null);

    Assertions.assertThat(morada.getId()).isEqualTo(1);
    Assertions.assertThat(morada.getDistrito()).isEqualTo("Aveiro");
    Assertions.assertThat(morada.getLocalidade()).isEqualTo("Gloria");
    Assertions.assertThat(morada.getRua()).isEqualTo("Rua xpto");
    Assertions.assertThat(morada.getCodigoPostal()).isEqualTo("3810-555");
  }

}
