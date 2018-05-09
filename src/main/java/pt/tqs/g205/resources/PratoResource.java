package pt.tqs.g205.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.services.PratoService;

@RestController
@RequestMapping(value = "/api/pratos")
public class PratoResource {

  @Autowired
  private PratoService pratoService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<?> getAll() {
    List<Prato> pratos = pratoService.getAll();

    return ResponseEntity.ok(pratos);
  }

}
