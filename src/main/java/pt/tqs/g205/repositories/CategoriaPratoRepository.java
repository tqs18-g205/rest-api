package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.CategoriaPrato;

import java.util.Collection;

/**
 * Operacoes de persistencia para as Categorias de pratos.
 */
@Repository
public interface CategoriaPratoRepository extends JpaRepository<CategoriaPrato, Integer> {
  Collection<CategoriaPrato> findByNome(String nome);
}
