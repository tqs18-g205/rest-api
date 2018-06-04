package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.EncomendaRestaurante;
import pt.tqs.g205.dto.EncomendaRestauranteDto;
import pt.tqs.g205.services.EncomendaRestauranteService;
import pt.tqs.g205.services.EncomendaService;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class EncomendaRestauranteServiceIntegration {
  @Autowired
  private EncomendaRestauranteService encomendaRestauranteService;
  
  @Autowired
  private EncomendaService encomendaService;
  
  private Encomenda enc;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    enc = encomendaService.getEncomendaById(1);
  }
  
  @Test
  public void fazerEncomenda() {
    List<EncomendaRestaurante> parcelas = encomendaRestauranteService.criarParcelas(enc);
    
    Assertions.assertThat(parcelas).isNotNull();
    Assertions.assertThat(parcelas).isNotEmpty();
    Assertions.assertThat(parcelas.size()).isGreaterThan(1);
    EncomendaRestaurante parcela = parcelas.iterator().next();
    Assertions.assertThat(parcela.getEncomenda()).isEqualTo(enc);
    Assertions.assertThat(parcela.getRestaurante()).isEqualTo(1);
    Assertions.assertThat(parcela.getId()).isNotNull();
    EncomendaRestaurante parcela2 = parcelas.get(1);
    Assertions.assertThat(parcela2.getEncomenda()).isEqualTo(enc);
    Assertions.assertThat(parcela2.getRestaurante()).isEqualTo(2);
    Assertions.assertThat(parcela2.getId()).isNotNull();
  }
  
  @Test
  public void getParcela() {
    EncomendaRestaurante parcela = encomendaRestauranteService.getParcela(1);
    Assertions.assertThat(parcela).isNotNull();
    Assertions.assertThat(parcela.getPratos()).isNotNull();
    Assertions.assertThat(parcela.getPratos()).isNotEmpty();
    Assertions.assertThat(parcela.getEstado()).isNotNull();
    Assertions.assertThat(parcela.getEncomenda()).isNotNull();
    Assertions.assertThat(parcela.getId()).isEqualTo(1);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void getParcelaFails() {
    encomendaRestauranteService.getParcela(0);
  }
  
  @Test
  public void getEncomendas() {
    List<EncomendaRestauranteDto> parcelas = encomendaRestauranteService.getEncomendas(1);
    Assertions.assertThat(parcelas).isNotNull();
    Assertions.assertThat(parcelas).isNotEmpty();
    EncomendaRestauranteDto parcela = parcelas.iterator().next();
    Assertions.assertThat(parcela).isNotNull();
    Assertions.assertThat(parcela.getEstado()).isNotNull();
    Assertions.assertThat(parcela.getTipoEntrega()).isNotNull();
    Assertions.assertThat(parcela.getId()).isNotNull();
    Assertions.assertThat(parcela.getId()).isGreaterThan(0);
  }
}
