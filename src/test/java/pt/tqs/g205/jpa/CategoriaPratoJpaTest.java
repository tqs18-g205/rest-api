package pt.tqs.g205.jpa;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.CategoriaPrato;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CategoriaPratoJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    CategoriaPrato cat = new CategoriaPrato(null, "Italiano");
    CategoriaPrato persisted = tem.persistAndFlush(cat);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getNome()).isEqualTo("Italiano");
  }
}
