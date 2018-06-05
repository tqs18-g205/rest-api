package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class EstadoEncomendaHoraTest {

  @Test
  public void create() {

    LocalDate ld = LocalDate.of(2018, 6, 22);
    LocalTime lt = LocalTime.of(12, 30);
    TipoEntrega tipoEntrega = new TipoEntrega(1, "TakeAway");
    Cliente cliente = new Cliente(1, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda enc = new Encomenda(1, tipoEntrega, cliente);

    EstadoEncomenda ee = new EstadoEncomenda(1, "Em preparação");
    EstadoEncomendaHora eeh = new EstadoEncomendaHora(enc, ee, ld, lt);

    EstadoEncomendaHoraPk eehPk = new EstadoEncomendaHoraPk(1, 1);

    Assertions.assertThat(eeh.getData()).isEqualTo(ld);
    Assertions.assertThat(eeh.getHora()).isEqualTo(lt);
    Assertions.assertThat(eeh.getEncomenda()).isEqualTo(enc);
    Assertions.assertThat(eeh.getId()).isEqualTo(eehPk);
    Assertions.assertThat(eeh.getEstadoEncomenda()).isEqualTo(ee);


  }

}
