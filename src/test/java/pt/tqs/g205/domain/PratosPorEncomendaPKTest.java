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
public class PratosPorEncomendaPKTest {

    @Test
    public void create() {

        PratosPorEncomendaPk ppePK = new PratosPorEncomendaPk(1,2);
        
        Assertions.assertThat(ppePK.getEncomendaId()).isNotNull();
        Assertions.assertThat(ppePK.getEncomendaId()).isEqualTo(1);
        Assertions.assertThat(ppePK.getPratoId()).isNotNull();
        Assertions.assertThat(ppePK.getPratoId()).isEqualTo(2);
        
    }

}
