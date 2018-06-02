package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.TipoCozinha;
import pt.tqs.g205.repositories.TipoCozinhaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Logica de negocios associada aos tipos de cozinha.
 */
@Service
public class TipoCozinhaService {
  @Autowired
  private TipoCozinhaRepository tipoCozinhaRepo;
  
  /**
   * Lista todos os tipos de cozinha.
   * @return lista de todos os tipos de cozinha.
   */
  public List<TipoCozinha> getAll() {
    return tipoCozinhaRepo.findAll();
  }

  /**
   * Obter descricao de um tipo de cozinha.
   * @param tipoCozinha id do tipo de cozinha.
   * @return descricao do tipo de cozinha.
   */
  public TipoCozinha getById(Integer tipoCozinha) {
    Optional<TipoCozinha> tipo = tipoCozinhaRepo.findById(tipoCozinha);
    
    if (!tipo.isPresent()) {
      throw new NoSuchElementException(); 
    }
    return tipo.get();
  }
}
