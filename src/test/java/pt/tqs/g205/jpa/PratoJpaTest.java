package pt.tqs.g205.jpa;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Prato;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class PratoJpaTest {
  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg");
    Prato persisted = tem.persistAndFlush(p1);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getNome()).isEqualTo("Arroz de pato");
    Assertions.assertThat(persisted.getIngredientes()).isEmpty();
  }
}
