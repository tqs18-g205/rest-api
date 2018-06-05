package pt.tqs.g205.jpa;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.domain.PratosPorEncomenda;
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.domain.TipoCozinha;
import pt.tqs.g205.domain.TipoEntrega;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class PratosPorEncomendaJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    CategoriaPrato cat = new CategoriaPrato(null, "Prato de Carne");
    TipoCozinha tc = new TipoCozinha(null, "Italiano");
    Restaurante res = new Restaurante(null, "Moliceiro", tc);
    Prato pra = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg", res);
    TipoEntrega te = new TipoEntrega(null, "TakeAway");
    Cliente cli = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda enc = new Encomenda(null, te, cli);
    PratosPorEncomenda ppe = new PratosPorEncomenda(enc, pra, 2);

    tem.persistAndFlush(cat);
    tem.persistAndFlush(tc);
    tem.persistAndFlush(res);
    tem.persistAndFlush(pra);
    tem.persistAndFlush(te);
    tem.persistAndFlush(cli);
    tem.persistAndFlush(enc);

    PratosPorEncomenda persisted = tem.persistAndFlush(ppe);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getQuantity()).isEqualTo(2);
    Assertions.assertThat(persisted.getEncomenda()).isEqualTo(enc);
    Assertions.assertThat(persisted.getPrato()).isEqualTo(pra);
  }

}
