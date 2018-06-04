package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.resources.models.EncomendaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.resources.models.ReservaModel;
import pt.tqs.g205.services.ClienteService;
import pt.tqs.g205.services.EncomendaService;
import pt.tqs.g205.services.ReservaService;

import java.util.List;

/**
 * Controlador REST para expôr serviços aos Clientes.
 */
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

  @Autowired
  private ClienteService clienteService;
  
  @Autowired
  private ReservaService reservaService;
  
  @Autowired
  private EncomendaService encomendaService;


  /**
   * Endpoint para registar clientes.
   * @return dados do cliente registado.
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<Cliente> registerCliente(@RequestBody RegistoClienteModel cliente) {
    Cliente cli = clienteService.registerCliente(cliente);

    return ResponseEntity.ok(cli);
  }

  /**
   * Endpoint para obter os dados de um cliente específico.
   * @param id id do cliente.
   * @return dados do cliente.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
    Cliente cliente = clienteService.getById(id);

    return ResponseEntity.ok(cliente);
  }
  

  /**
   * Endpoint para criar uma nova reserva.
   * @param id id do cliente que faz a reserva.
   * @param reserva dados da reserva.
   * @return instancia da reserva criada.
   */
  @RequestMapping(value = "/{id}/reservas", method = RequestMethod.POST)
  public ResponseEntity<Reserva> criarReserva(@PathVariable("id") Integer id,
      @RequestBody ReservaModel reserva) {
    Reserva res = reservaService.fazerReserva(reserva.getCliente(), reserva.getRestaurante(),
        reserva.getData(), reserva.getHora());

    return ResponseEntity.ok(res);

  }
  
  /**
   * Endpoint para obter as reservas de um cliente.
   * @param id id do cliente.
   * @return lista de reservas do cliente.
   */
  @RequestMapping(value = "/{id}/reservas", method = RequestMethod.GET)
  public ResponseEntity<List<Reserva>> getReservasCliente(@PathVariable("id") Integer id) {
    List<Reserva> reservas = reservaService.getByClienteId(id);

    return ResponseEntity.ok(reservas);
  }
  
  /**
   * Endpoint para obter as encomendas de um cliente.
   * @param id id do cliente.
   * @return lista de encomendas do cliente.
   */
  @RequestMapping(value = "/{id}/encomendas", method = RequestMethod.GET)
  public ResponseEntity<List<Encomenda>> getEncomendasCliente(@PathVariable("id") Integer id) {
    List<Encomenda> encomendas = encomendaService.getByClienteId(id);

    return ResponseEntity.ok(encomendas);
  }
  
  /**
   * Endpoint para obter detalhes de uma encomenda.
   * @param id id do cliente.
   * @param enc id da encomenda.
   * @return encomenda.
   */
  @RequestMapping(value = "/{id}/encomendas/{enc}", method = RequestMethod.GET)
  public ResponseEntity<Encomenda> getEncomenda(@PathVariable("id") Integer id,
      @PathVariable("enc") Integer enc) {
    Encomenda encomenda = encomendaService.getEncomendaById(enc);

    return ResponseEntity.ok(encomenda);
  }

  /**
   * Endpoint para fazer encomenda.
   * @param id id do cliente.
   * @param encomenda detalhes da encomenda.
   * @return encomenda.
   */
  @RequestMapping(value = "/{id}/encomendas", method = RequestMethod.POST)
  public ResponseEntity<Encomenda> criarEncomenda(@PathVariable("id") Integer id,
      @RequestBody EncomendaModel encomenda) {
    Encomenda enc = encomendaService.fazerEncomenda(id, encomenda);

    return ResponseEntity.ok(enc);
  }
}
