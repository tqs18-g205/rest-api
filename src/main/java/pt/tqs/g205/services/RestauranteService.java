package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.repositories.RestauranteRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Logica de negocios associada aos Restaurantes.
 */
@Service
public class RestauranteService {

  @Autowired
  private RestauranteRepository restauranteRepo;

  /**
   * Obter listagem de todos os restaurantes.
   * @return lista de todos os restaurantes.
   */
  public List<Restaurante> getAll() {
    List<Restaurante> restaurantes = restauranteRepo.findAll();
    restaurantes.forEach(e -> {
      e.setPratos(null);
      e.setReservas(null);
    });

    return restaurantes;
  }

  /**
   * Obter detalhes sobre um restaurante.
   * @param id id do restaurante.
   * @return detalhes do restaurante.
   */
  public Restaurante getById(Integer id) {
    Optional<Restaurante> res = restauranteRepo.findById(id);
    if (!res.isPresent()) {
      throw new NoSuchElementException();
    }
    return res.get();
  }
}
