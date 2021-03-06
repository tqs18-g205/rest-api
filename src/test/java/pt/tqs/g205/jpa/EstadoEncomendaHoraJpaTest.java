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
import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.domain.EstadoEncomendaHora;
import pt.tqs.g205.domain.TipoEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class EstadoEncomendaHoraJpaTest {

  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    TipoEntrega te = new TipoEntrega(null, "TakeAway");
    Cliente cli = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");
    Encomenda enc = new Encomenda(null, te, cli);
    EstadoEncomenda ee = new EstadoEncomenda(null, "Em preparação");
    EstadoEncomendaHora eeh =
        new EstadoEncomendaHora(enc, ee, LocalDate.of(2018, 6, 22), LocalTime.of(12, 30));

    tem.persistAndFlush(te);
    tem.persistAndFlush(cli);
    tem.persistAndFlush(enc);
    tem.persistAndFlush(ee);

    EstadoEncomendaHora persisted = tem.persistAndFlush(eeh);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getData()).isEqualTo(LocalDate.of(2018, 6, 22));
    Assertions.assertThat(persisted.getHora()).isEqualTo(LocalTime.of(12, 30));
    Assertions.assertThat(persisted.getEncomenda()).isEqualTo(enc);
    Assertions.assertThat(persisted.getEstadoEncomenda()).isEqualTo(ee);
  }

}
