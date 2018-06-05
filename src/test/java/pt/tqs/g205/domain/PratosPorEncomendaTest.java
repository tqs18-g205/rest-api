package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PratosPorEncomendaTest {

  @Test
  public void create() {

    TipoEntrega tipoEntrega = new TipoEntrega(1, "TakeAway");
    Cliente cliente = new Cliente(1, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda encomenda = new Encomenda(1, tipoEntrega, cliente);

    TipoCozinha tc = new TipoCozinha(1, "Italiano");
    Restaurante r1 = new Restaurante(1, "Moliceiro", tc);
    Prato p1 = new Prato(1, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", r1);

    PratosPorEncomendaPk ppePk = new PratosPorEncomendaPk(1, 1);

    PratosPorEncomenda ppe = new PratosPorEncomenda(encomenda, p1, 2);

    Assertions.assertThat(ppe.getId()).isNotNull();
    Assertions.assertThat(ppe.getId()).isEqualTo(ppePk);
    Assertions.assertThat(ppe.getEncomenda()).isNotNull();
    Assertions.assertThat(ppe.getEncomenda()).isEqualTo(encomenda);
    Assertions.assertThat(ppe.getPrato()).isNotNull();
    Assertions.assertThat(ppe.getPrato()).isEqualTo(p1);
    Assertions.assertThat(ppe.getQuantity()).isNotNull();
    Assertions.assertThat(ppe.getQuantity()).isEqualTo(2);

  }

}
