package pt.tqs.g205.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Reservas.
 */
@Entity
public class Reserva implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "restaurante_id")
  private Restaurante restaurante;

  private LocalDate data;
  private LocalTime time;

  public Reserva() {}
  
  /**
   * Constructor.
   * @param id id da reserva (autogerado).
   * @param cliente cliente.
   * @param restaurante restaurante.
   * @param data data.
   * @param time hora.
   */
  public Reserva(Integer id, Cliente cliente, Restaurante restaurante, LocalDate data,
      LocalTime time) {
    super();
    this.id = id;
    this.cliente = cliente;
    this.restaurante = restaurante;
    this.data = data;
    this.time = time;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Restaurante getRestaurante() {
    return restaurante;
  }

  public void setRestaurante(Restaurante restaurante) {
    this.restaurante = restaurante;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Reserva other = (Reserva) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

}
