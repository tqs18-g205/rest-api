package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IngredientesPorPratoTest {

  @Test
  public void creation() {
    Prato prato = new Prato(3, "Esparguete Bolonhesa", 7.0,
        "http://www.biodharma.pt/wp-content/uploads/2016/11/esprguete-%C3%A0-bolonhesa-1-370x237.jpg");
    Ingrediente ing = new Ingrediente(1, "Arroz", 25.0);

    IngredientesPorPrato ipp = new IngredientesPorPrato(prato, ing, 20.0);
    Assertions.assertThat(ipp.getId().getPratoId()).isEqualTo(3);
    Assertions.assertThat(ipp.getId().getIngredienteId()).isEqualTo(1);
    Assertions.assertThat(ipp.getQuantidade()).isEqualTo(20.0);
  }

}
