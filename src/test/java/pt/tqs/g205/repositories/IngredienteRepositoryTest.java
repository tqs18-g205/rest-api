package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Ingrediente;

@DataJpaTest
@RunWith(SpringRunner.class)
public class IngredienteRepositoryTest {
  @Autowired
  private IngredienteRepository ingredienteRepo;

  @Test
  public void findById() {
    Ingrediente persisted = ingredienteRepo.save(new Ingrediente(null, "Arroz", 100.0));
    Ingrediente ing = ingredienteRepo.findById(persisted.getId()).get();
    Assertions.assertThat(ing).isNotNull();
    Assertions.assertThat(ing.getId()).isEqualTo(persisted.getId());
  }
}
