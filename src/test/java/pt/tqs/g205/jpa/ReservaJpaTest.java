/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.tqs.g205.jpa;

import java.time.LocalDate;
import java.time.LocalTime;
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

/**
 *
 * @author joseppmoreira
 */
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
        Restaurante r = new Restaurante(null, "Moliceiro", tc);
        Cliente c = new Cliente(null, "John Doe", "1223", "999999999", "john@doe.com");
        Reserva res = new Reserva(null, c, r, LocalDate.of(2018, 9, 1), LocalTime.of(20, 0));
        
        tem.persistAndFlush(tc);
        tem.persistAndFlush(r);
        tem.persistAndFlush(c);
        
        Reserva persisted = tem.persistAndFlush(res);
        Assertions.assertThat(persisted.getId()).isNotNull();
        Assertions.assertThat(persisted.getId()).isGreaterThan(0);
        Assertions.assertThat(persisted.getCliente()).isEqualTo(c);
        Assertions.assertThat(persisted.getRestaurante()).isEqualTo(r);
        Assertions.assertThat(persisted.getData()).isEqualTo(LocalDate.of(2018, 9, 1));
        Assertions.assertThat(persisted.getTime()).isEqualTo(LocalTime.of(20, 0));
    }
    
}
