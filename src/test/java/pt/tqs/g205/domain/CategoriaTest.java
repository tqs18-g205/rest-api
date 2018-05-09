package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CategoriaTest {

  @Test
  public void creation() {
    CategoriaPrato c = new CategoriaPrato(1, "Italiano");
    Assertions.assertThat(c.getId()).isEqualTo(1);
    Assertions.assertThat(c.getNome()).isNotBlank();
    Assertions.assertThat(c.getNome()).isEqualTo("Italiano");
  }

}
