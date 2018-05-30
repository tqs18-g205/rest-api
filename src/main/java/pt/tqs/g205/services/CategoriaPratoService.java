package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.repositories.CategoriaPratoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Logica de servicos para as categorias de pratos.
 */
@Service
public class CategoriaPratoService {

  @Autowired
  private CategoriaPratoRepository categoriaRepo;

  /**
   * Obter todos os pratos.
   * 
   * @return lista de todos os pratos.
   */
  public List<CategoriaPrato> getAll() {
    List<CategoriaPrato> categorias = categoriaRepo.findAll();
    categorias.forEach(e -> e.setPratos(null));
    return categorias;
  }

  /**
   * Obter um prato por id.
   * 
   * @param id id do prato.
   * @return objeto de Prato.
   */
  public CategoriaPrato getById(Integer id) {
    Optional<CategoriaPrato> cat = categoriaRepo.findById(id);

    if (!cat.isPresent()) {
      throw new NoSuchElementException();
    }
    return cat.get();
  }


}
