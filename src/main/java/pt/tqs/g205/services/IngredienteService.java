package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.repositories.IngredienteRepository;

import java.util.List;

/**
 * Logica de servicos para os ingredientes.
 */
@Service
public class IngredienteService {

  @Autowired
  private IngredienteRepository ingredienteRepo;

  /**
   * Obter todos os ingredientes.
   * 
   * @return lista de ingredientes.
   */
  public List<Ingrediente> getAll() {
    return ingredienteRepo.findAll();
  }
}
