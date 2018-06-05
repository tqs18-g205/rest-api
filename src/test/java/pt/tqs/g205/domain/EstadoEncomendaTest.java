/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.tqs.g205.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author joseppmoreira
 */
public class EstadoEncomendaTest {
    
    @Test
    public void create(){
        
        EstadoEncomenda ee = new EstadoEncomenda(1, "Em preparação");
        
        Assertions.assertThat(ee.getId()).isEqualTo(1);
        Assertions.assertThat(ee.getDescricao()).isEqualTo("Em preparação");
        Assertions.assertThat(ee.getEncomendas()).isNotNull();
        Assertions.assertThat(ee.getEncomendas()).isEmpty();
    }
    
}
