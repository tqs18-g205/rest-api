package pt.tqs.g205.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Reserva;
import pt.tqs.g205.domain.Restaurante;

/**
 * Operacoes de persistencia para a entidade Reserva.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

  /**
   * Retorna uma lista de reservas associadas a um Cliente.
   * @param cliente cliente.
   * @return lista de reservas.
   */
  List<Reserva> getByCliente(Cliente cliente);

  /**
   * Retorna uma lista de reservas associadas a um Restaurante.
   * @param restaurante restaurante.
   * @return lista de reservas.
   */
  List<Reserva> getByRestaurante(Restaurante restaurante);
}
