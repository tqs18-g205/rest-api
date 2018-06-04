package pt.tqs.g205.services;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.domain.TipoCozinha;
import pt.tqs.g205.repositories.MoradaRepository;
import pt.tqs.g205.repositories.PratoRepository;
import pt.tqs.g205.repositories.ReservaRepository;
import pt.tqs.g205.repositories.RestauranteRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestauranteServiceTest {
  @Autowired
  private RestauranteService restauranteService;
  
  @MockBean
  private RestauranteRepository restauranteRepo;
  
  @MockBean
  private MoradaRepository moradaRepo;
  
  @MockBean
  private PratoRepository pratoRepository;
  
  @MockBean
  private ReservaRepository reservaRepository;
  
  @MockBean
  private EncomendaRestauranteService encomendaRestauranteService;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    Mockito.when(restauranteRepo.findAll())
        .thenReturn(Collections.singletonList(new Restaurante(1, "Moliceiro",
          new TipoCozinha(1, "Portuguesa"))));
    
    Mockito.when(restauranteRepo.findById(1))
      .thenReturn(Optional.of(new Restaurante(1, "Moliceiro", new TipoCozinha(1, "Portuguesa"))));
  }
  
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
