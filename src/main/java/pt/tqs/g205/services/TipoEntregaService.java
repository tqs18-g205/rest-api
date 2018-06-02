package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.TipoEntrega;
import pt.tqs.g205.repositories.TipoEntregaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Logica de negocio associada aos tipos de entrega.
 */
@Service
public class TipoEntregaService {

  @Autowired
  private TipoEntregaRepository tipoEntregaRepo;

  /**
   * Lista todos os tipos de entrega.
   * @return lista de todos os tipos de entrega.
   */
  public List<TipoEntrega> getAll() {
    return tipoEntregaRepo.findAll();
  }

  /**
   * Obter descricao de um tipo de entrega.
   * @param tipoEntrega id do tipo de entrega.
   * @return descricao do tipo de entrega.
   */
  public TipoEntrega getById(Integer tipoEntrega) {
    Optional<TipoEntrega> tipo = tipoEntregaRepo.findById(tipoEntrega);
    
    if (!tipo.isPresent()) {
      throw new NoSuchElementException(); 
    }
    return tipo.get();
  }
}
