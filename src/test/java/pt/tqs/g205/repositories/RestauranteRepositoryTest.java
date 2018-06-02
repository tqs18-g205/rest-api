package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Restaurante;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestauranteRepositoryTest {
  @Autowired
  private RestauranteRepository restauranteRepo;
  
  @Test
  public void findById() {
    Restaurante res = restauranteRepo.findById(1).get();
    
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getId()).isEqualTo(1);
  }
}
