package pt.tqs.g205.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Morada;

@Repository
public interface MoradaRepository extends JpaRepository<Morada, Integer> {

}
