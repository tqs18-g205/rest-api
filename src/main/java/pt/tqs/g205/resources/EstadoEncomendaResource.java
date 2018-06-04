package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.services.EstadoEncomendaService;

import java.util.List;

/**
 * Controlador REST para expor Estados de Encomenda.
 */
@RestController
@RequestMapping(value = "/api/estadosencomenda")
public class EstadoEncomendaResource {
  @Autowired
  private EstadoEncomendaService estadoEncomendaService;
  
  /**
   * Obter todos os estados de encomenda.
   * 
   * @return lista de todos os estados de encomenda.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<EstadoEncomenda>> getAll() {
    List<EstadoEncomenda> tipos = estadoEncomendaService.getAll();

    return ResponseEntity.ok(tipos);
  }

}
