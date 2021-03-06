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

import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.domain.TipoCozinha;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class RestauranteJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    TipoCozinha tc = new TipoCozinha(null, "Italiano");
    Restaurante rest = new Restaurante(null, "Moliceiro", tc);

    tem.persistAndFlush(tc);

    Restaurante persisted = tem.persistAndFlush(rest);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getNome()).isEqualTo("Moliceiro");
    Assertions.assertThat(persisted.getPratos()).isEmpty();
    Assertions.assertThat(persisted.getReservas()).isEmpty();
    Assertions.assertThat(persisted.getTiposEntrega()).isEmpty();
    Assertions.assertThat(persisted.getTipoCozinha()).isEqualTo(tc);
  }

}
