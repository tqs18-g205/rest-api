package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Encomenda;

import java.util.List;

/**
 * Operacoes de persistencia para a entidade Encomenda.
 */
@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {

  List<Encomenda> getByClienteId(Integer clienteId);

}
