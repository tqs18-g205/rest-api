package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.EncomendaRestaurante;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EncomendaRestauranteRepositoryTest {
  @Autowired
  private EncomendaRestauranteRepository encomendaRestauranteRepo;
  
  @Test
  public void findByRestaurante() {
    List<EncomendaRestaurante> parcelas = encomendaRestauranteRepo.findByRestaurante(1);
    
    Assertions.assertThat(parcelas).isNotNull();
    Assertions.assertThat(parcelas).isNotEmpty();
    Assertions.assertThat(parcelas.iterator().next().getRestaurante()).isEqualTo(1);
  }

}
