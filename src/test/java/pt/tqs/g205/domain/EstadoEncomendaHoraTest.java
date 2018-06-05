/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.tqs.g205.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author joseppmoreira
 */
public class EstadoEncomendaHoraTest {
    
    @Test
    public void create(){
        
        LocalDate ld = LocalDate.of(2018, 6, 22);
        LocalTime lt = LocalTime.of(12, 30);
        TipoEntrega tipoEntrega = new TipoEntrega(1, "TakeAway");
        Cliente cliente = new Cliente(1, "John Doe", "1223", "999999999", "john@doe.com");
        Encomenda enc = new Encomenda(1, tipoEntrega, cliente);
        
        EstadoEncomenda ee = new EstadoEncomenda(1, "Em preparação");
        EstadoEncomendaHora eeh = new EstadoEncomendaHora(enc, ee, ld, lt);
        
        EstadoEncomendaHoraPk eehPK = new EstadoEncomendaHoraPk(1,1);
        
        Assertions.assertThat(eeh.getData()).isEqualTo(ld);
        Assertions.assertThat(eeh.getHora()).isEqualTo(lt);
        Assertions.assertThat(eeh.getEncomenda()).isEqualTo(enc);
        Assertions.assertThat(eeh.getId()).isEqualTo(eehPK);
        Assertions.assertThat(eeh.getEstadoEncomenda()).isEqualTo(ee);
        
        
    }
    
}
