package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.TipoEntrega;
import pt.tqs.g205.services.TipoEntregaService;

import java.util.List;

/**
 * Controlador REST para expor Pratos.
 */
@RestController
@RequestMapping(value = "/api/tiposentrega")
public class TipoEntregaResource {
  
  @Autowired
  private TipoEntregaService tipoEntregaService;

  /**
   * Obter todos os tipos de entrega.
   * 
   * @return lista de todos os tipos de entrega.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<TipoEntrega>> getAll() {
    List<TipoEntrega> tipos = tipoEntregaService.getAll();

    return ResponseEntity.ok(tipos);
  }

}
