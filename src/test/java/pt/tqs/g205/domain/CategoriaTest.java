package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CategoriaTest {

  @Test
  public void creation() {
    CategoriaPrato cat = new CategoriaPrato(1, "Italiano");
    Assertions.assertThat(cat.getId()).isEqualTo(1);
    Assertions.assertThat(cat.getNome()).isNotBlank();
    Assertions.assertThat(cat.getNome()).isEqualTo("Italiano");
  }

}
