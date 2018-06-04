package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.EncomendaRestaurante;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.dto.EncomendaRestauranteDto;
import pt.tqs.g205.services.EncomendaRestauranteService;
import pt.tqs.g205.services.ReservaService;
import pt.tqs.g205.services.RestauranteService;

import java.util.List;

/**
 * Controlador REST para expor Restaurantes.
 */
@RestController
@RequestMapping(value = "/api/restaurantes")
public class RestauranteResource {

  @Autowired
  private RestauranteService restauranteService;
  
  @Autowired
  private ReservaService reservaService;
  
  @Autowired
  private EncomendaRestauranteService encomendaRestauranteService;

  /**
   * Endpoint para obter lista de todos os restaurantes.
   * @return lista de todos os restaurantes.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<Restaurante>> getRestaurantes() {
    List<Restaurante> restaurantes = restauranteService.getAll();

    return ResponseEntity.ok(restaurantes);
  }

  /**
   * Obter detalhes de um restaurante.
   * @param id id do restaurante.
   * @return detalhes do restaurante.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Restaurante> getRestauranteById(@PathVariable("id") Integer id) {
    Restaurante restaurante = restauranteService.getById(id);

    return ResponseEntity.ok(restaurante);
  }
  
  /**
   * Endpoint para um restaurante obter as suas reservas.
   * @param id id do restaurante.
   * @return lista de reservas.
   */
  @RequestMapping(value = "/{id}/reservas", method = RequestMethod.GET)
  public ResponseEntity<List<Reserva>> getReservas(@PathVariable("id") Integer id) {
    List<Reserva> reservas = reservaService.getByRestauranteId(id);

    return ResponseEntity.ok(reservas);
  }
  
  /**
   * Endpoint para um restaurante obter todas as suas encomendas.
   * @param id id do restaurante.
   * @return lista de encomendas.
   */
  @RequestMapping(value = "/{id}/encomendas", method = RequestMethod.GET)
  public ResponseEntity<List<EncomendaRestauranteDto>> getEncomendas(@PathVariable("id") Integer id) {
    List<EncomendaRestauranteDto> parcelas = encomendaRestauranteService.getEncomendas(id);

    return ResponseEntity.ok(parcelas);
  }
  
  /**
   * Restaurante pode obter detalhes de uma encomenda.
   * @param id id do restaurante.
   * @param encomenda id da encomenda.
   * @return detalhes da encomenda.
   */
  @RequestMapping(value = "/{id}/encomendas/{encomenda}", method = RequestMethod.GET)
  public ResponseEntity<EncomendaRestaurante> getEncomenda(@PathVariable("id") Integer id, 
      @PathVariable("encomenda") Integer encomenda) {
    EncomendaRestaurante parcela = encomendaRestauranteService.getParcela(encomenda);

    return ResponseEntity.ok(parcela);
  }

}
