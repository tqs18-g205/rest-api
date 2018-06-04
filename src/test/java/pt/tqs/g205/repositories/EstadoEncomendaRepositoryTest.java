package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.EstadoEncomenda;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EstadoEncomendaRepositoryTest {
  @Autowired
  private EstadoEncomendaRepository estadoEncomendaRepo;
  
  @Test
  public void findById() {
    EstadoEncomenda estado = estadoEncomendaRepo.findById(1).get();
    Assertions.assertThat(estado).isNotNull();
    Assertions.assertThat(estado.getId()).isEqualTo(1);
  }
}
