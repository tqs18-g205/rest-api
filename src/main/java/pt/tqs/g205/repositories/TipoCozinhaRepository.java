package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.TipoCozinha;

/**
 * Operacoes de persistencia para a entidade TipoCozinha.
 */
@Repository
public interface TipoCozinhaRepository extends JpaRepository<TipoCozinha, Integer> {

}
