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

import pt.tqs.g205.domain.TipoEntrega;
import pt.tqs.g205.repositories.TipoEntregaRepository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoEntregaServiceTeste {
  
  @Autowired
  private TipoEntregaService tipoEntregaService;
  
  @MockBean
  private TipoEntregaRepository repo;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    Mockito.when(repo.findAll())
      .thenReturn(Collections.singletonList(new TipoEntrega(1, "Take Away")));
    
    Mockito.when(repo.findById(1))
      .thenReturn(Optional.of(new TipoEntrega(1, "Take Away")));
    
    Mockito.when(repo.findById(2))
    .thenReturn(Optional.ofNullable(null));
  }
  
  @Test
  public void getAll() {
    List<TipoEntrega> tipos = tipoEntregaService.getAll();
    
    Assertions.assertThat(tipos).isNotNull();
    Assertions.assertThat(tipos).isNotEmpty();
    Assertions.assertThat(tipos.get(0)).isNotNull();
  }
  
  @Test
  public void getById() {
    TipoEntrega tipo = tipoEntregaService.getById(1);
    
    Assertions.assertThat(tipo).isNotNull();
    Assertions.assertThat(tipo.getId()).isEqualTo(1);
  }
  
  @Test(expected=NoSuchElementException.class)
  public void getByIdFails() {
    tipoEntregaService.getById(2);
  }
}
