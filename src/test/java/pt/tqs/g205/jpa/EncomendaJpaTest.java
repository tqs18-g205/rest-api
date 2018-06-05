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

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.TipoEntrega;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class EncomendaJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    TipoEntrega te = new TipoEntrega(null, "Entrega ao domicilio");
    Cliente cli = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda enc = new Encomenda(null, te, cli);

    tem.persistAndFlush(te);
    tem.persistAndFlush(cli);

    Encomenda persisted = tem.persistAndFlush(enc);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getCliente()).isEqualTo(cli);
    Assertions.assertThat(persisted.getEstados()).isEmpty();
    Assertions.assertThat(persisted.getPratos()).isEmpty();
    Assertions.assertThat(persisted.getTipoEntrega()).isEqualTo(te);
  }

}
