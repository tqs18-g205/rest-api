package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.domain.Restaurante;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservaRepositoryTest {
  @Autowired
  private ReservaRepository reservaRepo;
  
  @Autowired
  private ClienteRepository clienteRepo;
  
  @Autowired
  private RestauranteRepository restauranteRepo;
  
  @Test
  public void findByCliente() {
    Cliente cliente = clienteRepo.findById(1).get();
    List<Reserva> reservas = reservaRepo.getByCliente(cliente);
    
    Assertions.assertThat(reservas).isNotNull();
    Assertions.assertThat(reservas).isNotEmpty();
    Reserva res = reservas.iterator().next();
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getCliente()).isNotNull();
    Assertions.assertThat(res.getCliente()).isEqualTo(cliente);
    Assertions.assertThat(res.getRestaurante()).isNotNull();
  }
  
  @Test
  public void findByRestaurante() {
    Restaurante restaurante = restauranteRepo.findById(1).get();
    List<Reserva> reservas = reservaRepo.getByRestaurante(restaurante);
    
    Assertions.assertThat(reservas).isNotNull();
    Assertions.assertThat(reservas).isNotEmpty();
    Reserva res = reservas.iterator().next();
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getRestaurante()).isNotNull();
    Assertions.assertThat(res.getRestaurante()).isEqualTo(restaurante);
    Assertions.assertThat(res.getCliente()).isNotNull();
  }

}
