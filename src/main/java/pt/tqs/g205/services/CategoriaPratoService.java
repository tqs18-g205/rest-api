package pt.tqs.g205.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.repositories.CategoriaPratoRepository;

@Service
public class CategoriaPratoService {

  @Autowired
  private CategoriaPratoRepository categoriaRepo;

  public List<CategoriaPrato> getAll() {
    List<CategoriaPrato> categorias = categoriaRepo.findAll();
    categorias.forEach(e -> e.setPratos(null));
    return categorias;
  }

  public CategoriaPrato getById(Integer id) {
    Optional<CategoriaPrato> cat = categoriaRepo.findById(id);

    return cat.orElseThrow(() -> new NoSuchElementException());
  }


}
