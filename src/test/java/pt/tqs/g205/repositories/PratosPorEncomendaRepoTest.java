package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.PratosPorEncomenda;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PratosPorEncomendaRepoTest {
  @Autowired
  private PratosPorEncomendaRepository ppeRepo;
  
  @Test
  public void findAll() {
    List<PratosPorEncomenda> lista = ppeRepo.findAll();
    
    Assertions.assertThat(lista).isNotNull();
    Assertions.assertThat(lista).isNotEmpty();
    Assertions.assertThat(lista.iterator().next().getId()).isNotNull();
  }
}
