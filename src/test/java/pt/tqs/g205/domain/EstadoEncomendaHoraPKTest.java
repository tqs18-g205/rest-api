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
public class EstadoEncomendaHoraPKTest {
    
    @Test
    public void create(){
        
        EstadoEncomendaHoraPk eehPK = new EstadoEncomendaHoraPk(1,2);
        
        Assertions.assertThat(eehPK.getEncomenda()).isEqualTo(1);
        Assertions.assertThat(eehPK.getEstado()).isEqualTo(2);
        
    }
    
}
