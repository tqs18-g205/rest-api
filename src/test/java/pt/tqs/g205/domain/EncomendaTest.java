package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EncomendaTest {

  @Test
  public void create() {

    TipoEntrega tipoEntrega = new TipoEntrega(1, "TakeAway");
    Cliente cliente = new Cliente(1, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda encomenda = new Encomenda(1, tipoEntrega, cliente);

    Assertions.assertThat(encomenda.getId()).isNotZero();
    Assertions.assertThat(encomenda.getTipoEntrega()).isEqualTo(tipoEntrega);
    Assertions.assertThat(encomenda.getCliente()).isEqualTo(cliente);
    Assertions.assertThat(encomenda.getPratos()).isNotNull();
    Assertions.assertThat(encomenda.getPratos()).isEmpty();
    Assertions.assertThat(encomenda.getEstados()).isNotNull();
    Assertions.assertThat(encomenda.getEstados()).isEmpty();

  }

}
