package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.ReservaRepository;
import pt.tqs.g205.repositories.RestauranteRepository;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Logica de negocio associada as Reservas.
 */
@Service
public class ReservaService {

  @Autowired
  private ReservaRepository reservaRepo;

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private RestauranteService restauranteService;

  @Autowired
  private RestauranteRepository restauranteRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  /**
   * Faz uma reserva.
   * @param cliente id do cliente.
   * @param restaurante id do restaurante.
   * @param data data da reserva.
   * @param hora hora da reserva.
   * @return reserva criada.
   */
  public Reserva fazerReserva(Integer cliente, Integer restaurante, String data, String hora) {
    Cliente cli = clienteService.getById(cliente);
    Restaurante res = restauranteService.getById(restaurante);

    String[] d = data.split("-");
    LocalDate date =
        LocalDate.of(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));

    String[] h = hora.split(":");
    LocalTime hour = LocalTime.of(Integer.parseInt(h[0]), Integer.parseInt(h[1]));

    Reserva reserva = new Reserva(null, cli, res, date, hour);

    cli.getReservas().add(reserva);
    res.getReservas().add(reserva);

    Reserva resultado = reservaRepo.save(reserva);
    clienteRepo.save(cli);
    restauranteRepo.save(res);

    return resultado;
  }


}
