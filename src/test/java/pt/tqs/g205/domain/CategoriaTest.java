package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CategoriaTest {

  @Test
  public void creation() {
    CategoriaPrato catPrato = new CategoriaPrato(1, "Italiano");
    Assertions.assertThat(catPrato.getId()).isEqualTo(1);
    Assertions.assertThat(catPrato.getNome()).isNotBlank();
    Assertions.assertThat(catPrato.getNome()).isEqualTo("Italiano");
  }

}
