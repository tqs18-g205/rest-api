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
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.domain.TipoCozinha;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class ReservaJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    TipoCozinha tc = new TipoCozinha(null, "Italiano");
    Restaurante rest = new Restaurante(null, "Moliceiro", tc);
    Cliente cli = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");
    Reserva res = new Reserva(null, cli, rest, LocalDate.of(2018, 9, 1), LocalTime.of(20, 0));

    tem.persistAndFlush(tc);
    tem.persistAndFlush(rest);
    tem.persistAndFlush(cli);

    Reserva persisted = tem.persistAndFlush(res);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isGreaterThan(0);
    Assertions.assertThat(persisted.getCliente()).isEqualTo(cli);
    Assertions.assertThat(persisted.getRestaurante()).isEqualTo(rest);
    Assertions.assertThat(persisted.getData()).isEqualTo(LocalDate.of(2018, 9, 1));
    Assertions.assertThat(persisted.getTime()).isEqualTo(LocalTime.of(20, 0));
  }

}
