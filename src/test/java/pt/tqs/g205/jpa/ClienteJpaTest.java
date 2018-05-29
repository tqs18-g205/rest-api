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

@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@RunWith(SpringRunner.class)
public class ClienteJpaTest {
  @Autowired
  private TestEntityManager tem;

  @Test
  public void mapping() {
    Cliente cli = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");

    Cliente persisted = tem.persistAndFlush(cli);
    Assertions.assertThat(persisted.getId()).isNotNull();
    Assertions.assertThat(persisted.getId()).isNotZero();

  }
}
