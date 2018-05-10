package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Ingrediente;

/**
 * Operacoes de persistencia para os ingredientes.
 */
@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
