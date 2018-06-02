package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.TipoCozinha;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TipoCozinhaRepositoryTest {
  @Autowired
  private TipoCozinhaRepository tipoCozinhaRepo;
  
  @Test
  public void findById() {
    TipoCozinha tipo = tipoCozinhaRepo.findById(1).get();
    
    Assertions.assertThat(tipo).isNotNull();
    Assertions.assertThat(tipo.getId()).isEqualTo(1);
  }
}
