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

import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.domain.IngredientesPorPrato;
import pt.tqs.g205.domain.IngredientesPorPratoPk;
import pt.tqs.g205.domain.Prato;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class IngredientePorPratoJpaTest {
  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    Ingrediente i1 = new Ingrediente(null, "Arroz", 50.0);

    Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", null);

    IngredientesPorPrato ipp1 = new IngredientesPorPrato(p1, i1, 300.0);
    i1.setPratos(Arrays.asList(ipp1));
    p1.setIngredientes(Arrays.asList(ipp1));

    tem.persist(i1);
    tem.persist(p1);
    IngredientesPorPrato persisted = tem.persistAndFlush(ipp1);

    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getPrato()).isEqualTo(p1);
    Assertions.assertThat(persisted.getIngrediente()).isEqualTo(i1);
    Assertions.assertThat(persisted.getId())
        .isEqualTo(new IngredientesPorPratoPk(p1.getId(), i1.getId()));
  }
}
