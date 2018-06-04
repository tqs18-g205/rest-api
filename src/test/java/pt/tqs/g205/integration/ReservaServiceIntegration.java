package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.security.ClienteSs;
import pt.tqs.g205.services.ReservaService;
import pt.tqs.g205.services.UserService;

import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ReservaServiceIntegration {
  @Autowired
  private ReservaService reservaService;
  
  @Autowired
  private ClienteRepository clienteRepo;
  
  @MockBean
  private UserService userService;
  
  private Cliente cli;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    cli = clienteRepo.findById(1).get();
    
    Mockito.when(userService.authenticated())
      .thenReturn(new ClienteSs(cli.getId(), cli.getEmail(), cli.getPasswd()));
  }
  
  @Test
  public void fazerReserva() {
    Reserva reserva = reservaService.fazerReserva(1, 1, "03-07-2018", "20:00");
    Assertions.assertThat(reserva).isNotNull();
    Assertions.assertThat(reserva.getCliente()).isEqualTo(cli);
    Assertions.assertThat(reserva.getRestaurante()).isNotNull();
  }
  
  @Test
  public void getByClientId() {
    List<Reserva> reservas = reservaService.getByClienteId(1);
    Assertions.assertThat(reservas).isNotNull();
    Assertions.assertThat(reservas).isNotEmpty();
    Reserva res = reservas.iterator().next();
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getCliente().getId()).isEqualTo(1);
  }
  
  @Test
  public void getByRestauranteId() {
    List<Reserva> reservas = reservaService.getByRestauranteId(1);
    Assertions.assertThat(reservas).isNotNull();
    Assertions.assertThat(reservas).isNotEmpty();
    Reserva res = reservas.iterator().next();
    Assertions.assertThat(res).isNotNull();
    Assertions.assertThat(res.getRestaurante().getId()).isEqualTo(1);
  }
}
