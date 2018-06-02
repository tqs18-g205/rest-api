package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.services.RestauranteService;

import java.util.List;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class RestauranteServiceIntegration {
  @Autowired
  private RestauranteService restauranteService;
  
  @Test
  public void getAll() {
    List<Restaurante> restaurantes = restauranteService.getAll();
    
    Assertions.assertThat(restaurantes).isNotNull();
    Assertions.assertThat(restaurantes).isNotEmpty();
    
    Restaurante res = restaurantes.iterator().next();
    Assertions.assertThat(res.getId()).isEqualTo(1);
  }
  
  @Test
  public void getById() {
    Restaurante res = restauranteService.getById(1);
    
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getId()).isNotNull();
    Assertions.assertThat(res.getId()).isEqualTo(1);
  }
}
