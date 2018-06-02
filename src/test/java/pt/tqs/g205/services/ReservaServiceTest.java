package pt.tqs.g205.services;

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
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.ReservaRepository;
import pt.tqs.g205.repositories.RestauranteRepository;
import pt.tqs.g205.security.ClienteSs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ReservaServiceTest {
  @Autowired
  private ReservaService reservaService;
  
  @Autowired
  private ClienteRepository clienteRepo;
  
  @Autowired
  private RestauranteRepository restauranteRepo;
  
  @MockBean
  private ReservaRepository reservaRepo;
  
  @MockBean
  private UserService userService;
  
  private LocalDate date;
  private LocalTime time;
  private Cliente cli;
  private Restaurante res;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    cli = clienteRepo.findById(1).get();
    res = restauranteRepo.findById(1).get();
    date = LocalDate.now();
    time = LocalTime.now();
    
    Mockito.when(userService.authenticated())
      .thenReturn(new ClienteSs(1, "john@doe.com", "1234"));
    
    Mockito.when(reservaRepo.save(new Reserva(null, cli, res, date, time)))
      .thenReturn(new Reserva(1, cli, res, date, time));
    
    Mockito.when(reservaRepo.getByCliente(cli))
      .thenReturn(Collections.singletonList(new Reserva(1, cli, res, date, time)));
  }
  
  @Test
  public void fazerReserva() {
    Reserva reserva = reservaService.fazerReserva(1, 1, "03-07-2018", "20:00");
    Assertions.assertThat(reserva).isNotNull();
    Assertions.assertThat(reserva.getCliente()).isEqualTo(cli);
    Assertions.assertThat(reserva.getRestaurante()).isEqualTo(res);
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
}
