package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.List;

/**
 * Servicos para a classe Prato.
 */
@Service
public class PratoService {

  @Autowired
  private PratoRepository pratoRepo;
  
  /**
   * Obter todos os pratos.
   * @return lista de Pratos.
   */
  public List<Prato> getAll() {
    return pratoRepo.findAll();

  }

}
