package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Cliente;

/**
 * Métodos de persistência para a entidade Cliente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  Cliente findByEmail(String email);
}
