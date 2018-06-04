package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.services.EstadoEncomendaService;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class EstadoEncomendaServiceIntegration {
  @Autowired
  private EstadoEncomendaService estadoEncomendaService;
  
  @Test
  public void getById() {
    EstadoEncomenda estado = estadoEncomendaService.getById(1);
    Assertions.assertThat(estado).isNotNull();
    Assertions.assertThat(estado.getId()).isEqualTo(1);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void getByIdFails() {
    estadoEncomendaService.getById(0);
  }
  
  @Test
  public void getAll() {
    List<EstadoEncomenda> estados = estadoEncomendaService.getAll();
    
    Assertions.assertThat(estados).isNotNull();
    Assertions.assertThat(estados).isNotEmpty();
    Assertions.assertThat(estados.iterator().next()).isNotNull();
  }
}
