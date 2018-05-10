package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.IngredientesPorPrato;
import pt.tqs.g205.domain.IngredientesPorPratoPk;

import java.util.List;

/**
 * Operacoes de persistencia para os ingredientes por prato.
 */
@Repository
public interface IngredientesPorPratoRepository
    extends JpaRepository<IngredientesPorPrato, IngredientesPorPratoPk> {

  public List<IngredientesPorPrato> findByPratoId(Integer pratoId);
}
