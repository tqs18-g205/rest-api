package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PratosPorEncomendaPkTest {

  @Test
  public void create() {
    PratosPorEncomendaPk ppePk = new PratosPorEncomendaPk(1, 2);
    Assertions.assertThat(ppePk.getEncomendaId()).isNotNull();
    Assertions.assertThat(ppePk.getEncomendaId()).isEqualTo(1);
    Assertions.assertThat(ppePk.getPratoId()).isNotNull();
    Assertions.assertThat(ppePk.getPratoId()).isEqualTo(2);
  }

}
