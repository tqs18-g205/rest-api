package pt.tqs.g205.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.repositories.IngredienteRepository;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IngredienteService.class, IngredienteRepository.class})
public class IngredienteServiceTest {

  @MockBean
  private IngredienteRepository ingredienteRepo;

  @Autowired
  private IngredienteService ingredienteService;

  @Test
  public void getAll() {
    Mockito.when(ingredienteRepo.findAll())
        .thenReturn(Collections.singletonList(new Ingrediente(1, "Arroz", 100.0)));
    List<Ingrediente> ingredientes = ingredienteService.getAll();
    Assertions.assertThat(ingredientes).isNotNull();
    Assertions.assertThat(ingredientes).isNotEmpty();

    Ingrediente ing = ingredientes.iterator().next();
    Assertions.assertThat(ing).isNotNull();
    Assertions.assertThat(ing.getId()).isEqualTo(1);
    Assertions.assertThat(ing.getNome()).isEqualTo("Arroz");
    Assertions.assertThat(ing.getCalorias()).isEqualTo(100.0);
    Assertions.assertThat(ing.getPratos()).isNotNull();
    Assertions.assertThat(ing.getPratos()).isEmpty();
  }
}
