package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IngredienteTest {

  @Test
  public void creation() {
    Ingrediente ing = new Ingrediente(1, "Arroz", 25.0);
    Assertions.assertThat(ing.getId()).isEqualTo(1);
    Assertions.assertThat(ing.getNome()).isNotBlank();
    Assertions.assertThat(ing.getNome()).isEqualTo("Arroz");
    Assertions.assertThat(ing.getCalorias()).isEqualTo(25.0);
    Assertions.assertThat(ing.getPratos()).isNotNull();
  }
}
