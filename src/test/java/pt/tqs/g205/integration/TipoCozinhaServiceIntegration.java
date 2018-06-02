package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.TipoCozinha;
import pt.tqs.g205.services.TipoCozinhaService;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class TipoCozinhaServiceIntegration {
  @Autowired
  private TipoCozinhaService tipoCozinhaService;
  
  @Test
  public void getAll() {
    List<TipoCozinha> tipos = tipoCozinhaService.getAll();
    
    Assertions.assertThat(tipos).isNotNull();
    Assertions.assertThat(tipos).isNotEmpty();
    Assertions.assertThat(tipos.get(0)).isNotNull();
  }
  
  @Test
  public void getById() {
    TipoCozinha tipo = tipoCozinhaService.getById(1);
    
    Assertions.assertThat(tipo).isNotNull();
    Assertions.assertThat(tipo.getId()).isEqualTo(1);
  }
  
  @Test(expected=NoSuchElementException.class)
  public void getByIdFails() {
    tipoCozinhaService.getById(0);
  }

}
