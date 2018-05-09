package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
   * @return JSON com descricao sumaria de todos os pratos.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<?> getAll() {
    List<Prato> pratos = pratoService.getAll();

    return ResponseEntity.ok(pratos);
  }

}
