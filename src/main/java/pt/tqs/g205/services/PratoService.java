package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.IngredientesPorPrato;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.repositories.IngredientesPorPratoRepository;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Logica de servicos para os pratos.
 */
@Service
public class PratoService {

  @Autowired
  private PratoRepository pratoRepo;

  @Autowired
  private IngredientesPorPratoRepository ingredientesPorPratoRepo;
  
  /**
   * Obter todos os pratos.
   * @return lista de todos os pratos.
   */
  public List<Prato> getAll() {
    List<Prato> pratos = pratoRepo.findAll();

    pratos.forEach(e -> e.setIngredientes(null));

    return pratos;
  }
  
  /**
   * Obter um prato por id.
   * @param id id do prato.
   * @return prato filtrado.
   */
  public Prato getPratoById(Integer id) {
    Prato prato = pratoRepo.getOne(id);

    if (prato == null) {
      throw new NoSuchElementException();
    }
    
    List<IngredientesPorPrato> ingredientesPorPrato = ingredientesPorPratoRepo.findByPratoId(id);

    prato.setIngredientes(ingredientesPorPrato);

    return prato;
  }
  
  /**
   * Obter pratos pelo numero de calorias.
   * @param value valor maximo de calorias.
   * @return lista de pratos filtrados.
   */
  public List<Prato> getByCalorias(Double value) {
    List<Prato> pratos = pratoRepo.findAll();

    return pratos
        .stream()
        .filter(e -> e.getCalorias() <= value)
        .collect(Collectors.toList());
  }

}
