package pt.tqs.g205.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.repositories.PratoRepository;

/**
 * 
 * 
 *
 */
@Service
public class PratoService {

  @Autowired
  private PratoRepository pratoRepo;

  public List<Prato> getAll() {
    List<Prato> pratos = pratoRepo.findAll();

    return pratos;
  }

}
