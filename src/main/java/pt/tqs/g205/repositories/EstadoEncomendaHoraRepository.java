package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.EstadoEncomendaHora;
import pt.tqs.g205.domain.EstadoEncomendaHoraPk;

/**
 * Operacoes de persistencia para a entidade EstadoEncomendaHora.
 */
@Repository
public interface EstadoEncomendaHoraRepository
    extends JpaRepository<EstadoEncomendaHora, EstadoEncomendaHoraPk> {

}
