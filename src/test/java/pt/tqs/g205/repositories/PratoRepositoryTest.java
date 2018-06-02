package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Prato;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PratoRepositoryTest {
  @Autowired
  private PratoRepository pratoRepo;

  @Test
  public void findById() {
    Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", null);
    Prato persisted = pratoRepo.save(p1);
    Prato prato = pratoRepo.findById(persisted.getId()).get();
    Assertions.assertThat(prato).isNotNull();
    Assertions.assertThat(prato.getId()).isEqualTo(persisted.getId());
    Assertions.assertThat(prato).isEqualTo(p1);
  }
}
