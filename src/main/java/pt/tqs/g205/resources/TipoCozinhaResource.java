package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.TipoCozinha;
import pt.tqs.g205.services.TipoCozinhaService;

import java.util.List;

/**
 * Controlador REST para expor Pratos.
 */
@RestController
@RequestMapping(value = "/api/tiposcozinha")
public class TipoCozinhaResource {
  
  @Autowired
  private TipoCozinhaService tipoCozinhaService;

  /**
   * Obter todos os tipos de cozinha.
   * 
   * @return lista de todos os tipos de cozinha.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<TipoCozinha>> getAll() {
    List<TipoCozinha> tipos = tipoCozinhaService.getAll();

    return ResponseEntity.ok(tipos);
  }
}
