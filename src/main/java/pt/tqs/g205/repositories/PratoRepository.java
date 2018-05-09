package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tqs.g205.domain.Prato;

/**
 * 
 * 
 *
 */
@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

}
