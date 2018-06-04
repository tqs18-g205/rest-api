package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.resources.models.EncomendaModel;
import pt.tqs.g205.security.ClienteSs;
import pt.tqs.g205.services.EncomendaService;
import pt.tqs.g205.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class EncomendaServiceIntegrationTest {
  @Autowired
  private EncomendaService encomendaService;
  
  @MockBean
  private UserService userService;
  
  private EncomendaModel model;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    model = new EncomendaModel(1, 1);
    Map<Integer, Integer> pratos = new HashMap<>();
    pratos.put(1, 1);
    pratos.put(2, 1);
    pratos.put(7, 1);
    model.setPratos(pratos);
    
    Mockito.when(userService.authenticated())
      .thenReturn(new ClienteSs(1, "chicomatos@ua.pt", "1234"));
  }
  
  @Test
  public void getAll() {
    List<Encomenda> encomendas = encomendaService.getAll();
    
    Assertions.assertThat(encomendas).isNotNull();
    Assertions.assertThat(encomendas).isNotEmpty();
    Assertions.assertThat(encomendas.iterator().next()).isNotNull();
  }
  
  @Test
  public void getByClienteId() {
    List<Encomenda> encomendas = encomendaService.getByClienteId(1);
    Assertions.assertThat(encomendas).isNotNull();
    Assertions.assertThat(encomendas).isNotEmpty();
    Assertions.assertThat(encomendas.iterator().next()).isNotNull();
  }
  
  @Test
  public void getByEncomendaId() {
    Encomenda enc = encomendaService.getEncomendaById(1);
    Assertions.assertThat(enc).isNotNull();
    Assertions.assertThat(enc.getId()).isEqualTo(1);
  }
  
  @Test
  public void fazerEncomenda() {
    Encomenda enc = encomendaService.fazerEncomenda(1, model);
    Assertions.assertThat(enc).isNotNull();
    Assertions.assertThat(enc.getCliente().getId()).isEqualTo(1);
    Assertions.assertThat(enc.getPratos()).isNotEmpty();
  }
}
