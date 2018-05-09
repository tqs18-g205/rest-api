package pt.tqs.g205.services;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.repositories.CategoriaPratoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CategoriaPratoService.class, CategoriaPratoRepository.class})
public class CategoriaPratoServiceTest {

  @Autowired
  private CategoriaPratoService categoriaService;

  @MockBean
  private CategoriaPratoRepository categoriaRepo;


  @Test
  public void getAll() {
    Mockito.when(categoriaRepo.findAll())
        .thenReturn(Collections.singletonList(new CategoriaPrato(1, "Carne")));

    List<CategoriaPrato> categorias = categoriaService.getAll();

    Assertions.assertThat(categorias).isNotNull();
    Assertions.assertThat(categorias).isNotEmpty();

    CategoriaPrato cat = categorias.iterator().next();
    Assertions.assertThat(cat).isNotNull();
    Assertions.assertThat(cat.getId()).isEqualTo(1);
    Assertions.assertThat(cat.getNome()).isEqualTo("Carne");
    Assertions.assertThat(cat.getPratos()).isNull();
  }

  @Test
  public void getById() {
    Mockito.when(categoriaRepo.findById(1)).thenReturn(Optional.of(new CategoriaPrato(1, "Carne")));

    CategoriaPrato cat = categoriaService.getById(1);
    Assertions.assertThat(cat).isNotNull();
    Assertions.assertThat(cat.getId()).isEqualTo(1);
    Assertions.assertThat(cat.getNome()).isEqualTo("Carne");

  }

  @Test(expected = NoSuchElementException.class)
  public void getByIdNull() {
    Mockito.when(categoriaRepo.findById(1)).thenReturn(Optional.ofNullable(null));

    categoriaService.getById(1);

  }
}
