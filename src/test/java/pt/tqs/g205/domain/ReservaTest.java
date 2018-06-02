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

    Reserva reserva = new Reserva(1, cliente, rest, ld, lt);

    Assertions.assertThat(reserva.getId()).isNotNull();
    Assertions.assertThat(reserva.getId()).isEqualTo(1);
    Assertions.assertThat(reserva.getCliente()).isNotNull();
    Assertions.assertThat(reserva.getCliente()).isEqualTo(cliente);
    Assertions.assertThat(reserva.getRestaurante()).isNotNull();
    Assertions.assertThat(reserva.getRestaurante()).isEqualTo(rest);
    Assertions.assertThat(reserva.getData()).isNotNull();
    Assertions.assertThat(reserva.getData()).isEqualTo(ld);
    Assertions.assertThat(reserva.getTime()).isNotNull();
    Assertions.assertThat(reserva.getTime()).isEqualTo(lt);

  }

}
