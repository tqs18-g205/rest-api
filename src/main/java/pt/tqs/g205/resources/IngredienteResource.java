package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.services.IngredienteService;

import java.util.List;

/**
 * Controlador REST para expor ingredientes.
 */
@RestController
@RequestMapping(value = "/api/ingredientes")
public class IngredienteResource {

  @Autowired
  private IngredienteService ingredienteService;

  /**
   * Endpoint para obter todos os ingredientes.
   * 
   * @return todos os ingredientes.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<Ingrediente>> getAll() {
    List<Ingrediente> ingredientes = ingredienteService.getAll();

    return ResponseEntity.ok(ingredientes);
  }
}
