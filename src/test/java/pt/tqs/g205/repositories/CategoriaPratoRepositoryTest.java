package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.CategoriaPrato;

import java.util.Collection;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CategoriaPratoRepositoryTest {

  @Autowired
  private CategoriaPratoRepository categoriaRepo;

  @Test
  public void findByName() {
    categoriaRepo.save(new CategoriaPrato(null, "Italiano"));
    Collection<CategoriaPrato> categorias = categoriaRepo.findByNome("Italiano");
    Assertions.assertThat(categorias.size()).isEqualTo(1);
    Assertions.assertThat(categorias.iterator().next().getId()).isGreaterThan(0);
    Assertions.assertThat(categorias.iterator().next().getNome()).isEqualTo("Italiano");
  }

  @Test
  public void findById() {
    CategoriaPrato cat = categoriaRepo.save(new CategoriaPrato(null, "Italiano"));
    Optional<CategoriaPrato> categoria = categoriaRepo.findById(cat.getId());
    Assertions.assertThat(categoria.get().getId()).isEqualTo(cat.getId());

  }
}
