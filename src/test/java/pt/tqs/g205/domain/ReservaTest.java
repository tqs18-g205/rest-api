package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;


public class ReservaTest {

  @Test
  public void create() {

    Cliente cliente = new Cliente(1, "José Moreira", "1234", "999999999", "jose@moreira.pt");
    TipoCozinha tc = new TipoCozinha(null, "Mediterrânio");
    Restaurante rest = new Restaurante(null, "D. Fernando", tc);
    LocalDate ld = LocalDate.of(2018, 6, 22);
    LocalTime lt = LocalTime.of(12, 30);

    Reserva r = new Reserva(1, cliente, rest, ld, lt);

    Assertions.assertThat(r.getId()).isNotNull();
    Assertions.assertThat(r.getId()).isEqualTo(1);
    Assertions.assertThat(r.getCliente()).isNotNull();
    Assertions.assertThat(r.getCliente()).isEqualTo(cliente);
    Assertions.assertThat(r.getRestaurante()).isNotNull();
    Assertions.assertThat(r.getRestaurante()).isEqualTo(rest);
    Assertions.assertThat(r.getData()).isNotNull();
    Assertions.assertThat(r.getData()).isEqualTo(ld);
    Assertions.assertThat(r.getTime()).isNotNull();
    Assertions.assertThat(r.getTime()).isEqualTo(lt);

  }

}
