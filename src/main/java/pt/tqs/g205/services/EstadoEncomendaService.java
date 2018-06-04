package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.repositories.EstadoEncomendaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstadoEncomendaService {

  @Autowired
  private EstadoEncomendaRepository estadoEncomendaRepo;
  
  /**
   * Obter a listagem de todos os estados possiveis para encomendas.
   * @return lista de estados.
   */
  public List<EstadoEncomenda> getAll() {
    return estadoEncomendaRepo.findAll();
  }

  /**
   * Obter os detalhes de um estado da encomenda.
   * @param id id do estado.
   * @return estado da encomenda.
   */
  public EstadoEncomenda getById(Integer id) {
    Optional<EstadoEncomenda> estado = estadoEncomendaRepo.findById(id);
    
    if (!estado.isPresent()) {
      throw new NoSuchElementException();
    }
    return estado.get();
  }
}
