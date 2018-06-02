package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PratoTest {

  @Test
  public void creation() {
    Prato prato = new Prato(1, "Esparguete Bolonhesa", 7.0,
        "http://www.biodharma.pt/wp-content/uploads/2016/11/esprguete-%C3%A0-bolonhesa-1-370x237.jpg",
        null);
    Assertions.assertThat(prato.getId()).isEqualTo(1);
    Assertions.assertThat(prato.getNome()).isNotBlank();
    Assertions.assertThat(prato.getNome()).isEqualTo("Esparguete Bolonhesa");
    Assertions.assertThat(prato.getIngredientes()).isNotNull();
  }

}
