package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.TipoEntrega;

/**
 * Operacoes de persistencia para a entidade TipoEntrega.
 */
@Repository
public interface TipoEntregaRepository extends JpaRepository<TipoEntrega, Integer> {

}
