package pt.tqs.g205.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.repositories.IngredientesPorPratoRepositoryTest;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PratoServiceTest {

  @MockBean
  private PratoRepository pratoRepo;

  @MockBean
  private CategoriaPratoService categoriaService;

  @MockBean
  private IngredientesPorPratoRepositoryTest ingredientesPorPratoRepo;

  @Autowired
  private PratoService pratoService;

  @Test
  public void getAll() {
    Prato p1 = new Prato(1, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", null);
    Mockito.when(pratoRepo.findAll()).thenReturn(Collections.singletonList(p1));
    List<Prato> pratos = pratoService.getAll();
    Assertions.assertThat(pratos).isNotNull();
    Assertions.assertThat(pratos).isNotEmpty();
    Assertions.assertThat(pratos.size()).isEqualTo(1);
    Prato prato = pratos.iterator().next();
    Assertions.assertThat(prato).isNotNull();
    Assertions.assertThat(prato).isEqualTo(p1);
  }

  @Test
  public void getPratoById() {
    Prato p1 = new Prato(1, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", null);
    Mockito.when(pratoRepo.getOne(1)).thenReturn(p1);
    Prato prato = pratoService.getPratoById(1);
    Assertions.assertThat(prato).isNotNull();
    Assertions.assertThat(prato).isEqualTo(p1);
  }

  @Test(expected = NoSuchElementException.class)
  public void getPratoByIdException() {
    Mockito.when(pratoRepo.getOne(1)).thenReturn(null);
    pratoService.getPratoById(1);
  }

  @Test
  public void getByCalorias() {
    Prato p1 = new Prato(1, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", null);
    Mockito.when(pratoRepo.findAll()).thenReturn(Collections.singletonList(p1));
    List<Prato> pratos = pratoService.getByCalorias(500.0);
    Assertions.assertThat(pratos).isNotNull();
    Assertions.assertThat(pratos).isNotEmpty();
    Assertions.assertThat(pratos.size()).isEqualTo(1);
    Prato prato = pratos.iterator().next();
    Assertions.assertThat(prato).isNotNull();
    Assertions.assertThat(prato).isEqualTo(p1);
  }


}
