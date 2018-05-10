package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.services.PratoService;

import java.util.List;

/**
 * Controlador REST para expor pratos.
 */
@RestController
@RequestMapping(value = "/api/pratos")
public class PratoResource {

  @Autowired
  private PratoService pratoService;
  
  /**
   * Endpoint para obter todos os pratos.
   * @return todos os pratos.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<Prato>> getAll() {
    List<Prato> pratos = pratoService.getAll();

    return ResponseEntity.ok(pratos);
  }
  
  /**
   * Endpoint para obter detalhes de um prato por id.
   * @param id id do prato.
   * @return detalhes do prato.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Prato> getPrato(@PathVariable("id") Integer id) {
    Prato prato = pratoService.getPratoById(id);

    prato.getIngredientes().forEach(e -> e.setId(null));

    return ResponseEntity.ok(prato);
  }
  
  /**
   * Endpoint para obter por pratos pelas calorias.
   * @param value calorias maximas.
   * @return lista de pratos filtrados.
   */
  @RequestMapping(value = "/calorias/{value}", method = RequestMethod.GET)
  public ResponseEntity<List<Prato>> getPratosByCalorias(@PathVariable("value") Double value) {
    List<Prato> pratos = pratoService.getByCalorias(value);

    return ResponseEntity.ok(pratos);
  }

}
