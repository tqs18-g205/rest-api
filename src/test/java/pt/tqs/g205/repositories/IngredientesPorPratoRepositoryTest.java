package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.domain.IngredientesPorPrato;
import pt.tqs.g205.domain.IngredientesPorPratoPk;
import pt.tqs.g205.domain.Prato;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class IngredientesPorPratoRepositoryTest {
  @Autowired
  private IngredientesPorPratoRepository ingredientesPorPratoRepo;

  @Autowired
  private IngredienteRepository ingredienteRepo;

  @Autowired
  private PratoRepository pratoRepo;

  @Test
  public void findByPratoId() {
    Ingrediente i1 = new Ingrediente(null, "Arroz", 50.0);

    Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg");

    IngredientesPorPrato ipp1 = new IngredientesPorPrato(p1, i1, 300.0);
    i1.setPratos(Arrays.asList(ipp1));
    p1.setIngredientes(Arrays.asList(ipp1));

    ingredienteRepo.save(i1);
    pratoRepo.save(p1);
    ingredientesPorPratoRepo.save(ipp1);

    List<IngredientesPorPrato> ingredientes = ingredientesPorPratoRepo.findByPratoId(p1.getId());

    Assertions.assertThat(ingredientes).isNotNull();
    Assertions.assertThat(ingredientes).isNotEmpty();

    IngredientesPorPrato ipp = ingredientes.iterator().next();

    Assertions.assertThat(ipp.getId()).isEqualTo(new IngredientesPorPratoPk(p1.getId(), i1.getId()));
  }
}
