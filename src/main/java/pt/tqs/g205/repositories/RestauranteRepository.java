package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Restaurante;

/**
 * Operacoes de persistencia para a entidade Restaurante.
 */
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

}
