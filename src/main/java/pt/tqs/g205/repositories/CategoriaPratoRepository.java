package pt.tqs.g205.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tqs.g205.domain.CategoriaPrato;

@Repository
public interface CategoriaPratoRepository extends JpaRepository<CategoriaPrato, Integer> {
  Collection<CategoriaPrato> findByNome(String nome);
}
