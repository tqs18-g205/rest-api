/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pt.tqs.g205.domain.EstadoEncomenda;

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
public class EstadoEncomendaJpaTest {
    
    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping() {
        EstadoEncomenda c = new EstadoEncomenda(null, "Em preparação");
        EstadoEncomenda persisted = tem.persistAndFlush(c);
        Assertions.assertThat(persisted.getId()).isNotNull();
        Assertions.assertThat(persisted.getId()).isGreaterThan(0);
        Assertions.assertThat(persisted.getDescricao()).isEqualTo("Em preparação");
        Assertions.assertThat(persisted.getEncomendas()).isEmpty();
    }
    
}
