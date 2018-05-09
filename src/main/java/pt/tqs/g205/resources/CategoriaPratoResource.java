package pt.tqs.g205.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.services.CategoriaPratoService;

/**
 * 
 * 
 *
 */
@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaPratoResource {

  @Autowired
  private CategoriaPratoService categoriaService;

  @RequestMapping(value = "/pratos", method = RequestMethod.GET)
  public ResponseEntity<?> getAll() {
    List<CategoriaPrato> categorias = categoriaService.getAll();

    return ResponseEntity.ok(categorias);
  }
}
