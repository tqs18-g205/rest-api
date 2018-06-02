package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.services.RestauranteService;

import java.util.List;

/**
 * Controlador REST para expor Restaurantes
 */
@RestController
@RequestMapping(value = "/api/restaurantes")
public class RestauranteResource {

  @Autowired
  private RestauranteService restauranteService;

  /**
   * Endpoint para obter lista de todos os restaurantes.
   * @return lista de todos os restaurantes.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<?> getRestaurantes() {
    List<Restaurante> restaurantes = restauranteService.getAll();

    return ResponseEntity.ok(restaurantes);
  }

  /**
   * Obter detalhes de um restaurante.
   * @param id id do restaurante.
   * @return detalhes do restaurante.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> getRestauranteById(@PathVariable("id") Integer id) {
    Restaurante restaurante = restauranteService.getById(id);

    return ResponseEntity.ok(restaurante);
  }

}
