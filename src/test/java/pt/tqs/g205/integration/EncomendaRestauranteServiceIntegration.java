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
import pt.tqs.g205.services.EncomendaRestauranteService;
import pt.tqs.g205.services.EncomendaService;

import java.util.List;

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
  }
}
