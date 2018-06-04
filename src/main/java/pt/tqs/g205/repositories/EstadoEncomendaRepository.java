package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.EstadoEncomenda;

/**
 * Operacoes de persistencia para a entidade EstadoEncomenda.
 */
@Repository
public interface EstadoEncomendaRepository extends JpaRepository<EstadoEncomenda, Integer> {

}
