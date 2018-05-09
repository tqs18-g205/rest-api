package pt.tqs.g205.jpa;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Ingrediente;

@DataJpaTest
@RunWith(SpringRunner.class)
public class IngredienteJpaTest {
  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    Ingrediente ing = new Ingrediente(null, "Arroz", 100.0);
    Ingrediente persisted = tem.persistAndFlush(ing);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getNome()).isEqualTo("Arroz");
    Assertions.assertThat(persisted.getPratos()).isEmpty();
  }
}
