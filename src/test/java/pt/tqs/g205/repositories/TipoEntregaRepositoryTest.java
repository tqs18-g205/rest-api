package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.TipoEntrega;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TipoEntregaRepositoryTest {
  @Autowired
  private TipoEntregaRepository tipoEntregaRepo;
  
  @Test
  public void findById() {
    TipoEntrega tipo = tipoEntregaRepo.findById(1).get();
    
    Assertions.assertThat(tipo).isNotNull();
    Assertions.assertThat(tipo.getId()).isEqualTo(1);
  }

}
