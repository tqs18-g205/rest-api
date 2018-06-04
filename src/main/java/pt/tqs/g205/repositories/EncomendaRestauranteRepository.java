package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.EncomendaRestaurante;

import java.util.List;

/**
 * Operacoes de persistencia para a entidade EncomendaRestaurante.
 */
@Repository
public interface EncomendaRestauranteRepository extends JpaRepository<EncomendaRestaurante, Integer> {
  public List<EncomendaRestaurante> findByRestaurante(Integer restaurante);
}
