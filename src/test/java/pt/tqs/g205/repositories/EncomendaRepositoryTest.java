package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Encomenda;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EncomendaRepositoryTest {
  @Autowired
  private EncomendaRepository encomendaRepo;
  
  @Test
  public void findByClienteId() {
    List<Encomenda> enc = encomendaRepo.getByClienteId(1);
    
    Assertions.assertThat(enc).isNotNull();
    Assertions.assertThat(enc).isNotEmpty();
    Assertions.assertThat(enc.iterator().next().getCliente().getId()).isEqualTo(1);
  }
  
  @Test
  public void findByClienteIdFails() {
    List<Encomenda> enc = encomendaRepo.getByClienteId(0);
    
    Assertions.assertThat(enc).isNotNull();
    Assertions.assertThat(enc).isEmpty();
  }
}
