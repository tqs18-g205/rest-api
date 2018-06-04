package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.PratosPorEncomenda;
import pt.tqs.g205.domain.PratosPorEncomendaPK;

/**
 * Operacoes de persistencia para a entidade PratosPorEncomenda.
 */
@Repository
public interface PratosPorEncomendaRepository
    extends JpaRepository<PratosPorEncomenda, PratosPorEncomendaPK> {

}
