package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tqs.g205.domain.Prato;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PratoRepositoryTest {
  @Autowired
  private PratoRepository pratoRepo;

  @Test
  public void findById() {
    Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg");
    Prato persisted = pratoRepo.save(p1);
    Prato p = pratoRepo.findById(persisted.getId()).get();
    Assertions.assertThat(p).isNotNull();
    Assertions.assertThat(p.getId()).isEqualTo(persisted.getId());
    Assertions.assertThat(p).isEqualTo(p1);
  }
}
