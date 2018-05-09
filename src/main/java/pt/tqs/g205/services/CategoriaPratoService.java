package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.repositories.CategoriaPratoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Servicos para a classe CategoriaPrato.
 */
@Service
public class CategoriaPratoService {

  @Autowired
  private CategoriaPratoRepository categoriaRepo;
  
  /**
   * Obter todas as categorias de pratos.
   * @return lista de categorias.
   */
  public List<CategoriaPrato> getAll() {
    List<CategoriaPrato> categorias = categoriaRepo.findAll();
    categorias.forEach(e -> e.setPratos(null));
    return categorias;
  }
  
  /**
   * Obter uma categoria pelo seu id.
   * @param id id da categoria.
   * @return categoria.
   */
  public CategoriaPrato getById(Integer id) {
    Optional<CategoriaPrato> cat = categoriaRepo.findById(id);

    return cat.orElseThrow(() -> new NoSuchElementException());
  }


}
