package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Encomendas do lado do restaurante.
 */
@Entity
public class EncomendaRestaurante implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer restaurante;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "encomenda_id")
  private Encomenda encomenda;

  @Transient
  private List<Prato> pratos = new ArrayList<>();

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "estado_id")
  private EstadoEncomenda estado;

  public EncomendaRestaurante() {
    super();
  }

  /**
   * Construtor.
   * 
   * @param id id da parcela.
   * @param restaurante id do restaurante.
   * @param encomenda encomenda.
   * @param estado estado da parcela.
   */
  public EncomendaRestaurante(Integer id, Integer restaurante, Encomenda encomenda,
      EstadoEncomenda estado) {
    super();
    this.id = id;
    this.restaurante = restaurante;
    this.encomenda = encomenda;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRestaurante() {
    return restaurante;
  }

  public void setRestaurante(Integer restaurante) {
    this.restaurante = restaurante;
  }

  public Encomenda getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Encomenda encomenda) {
    this.encomenda = encomenda;
  }

  public List<Prato> getPratos() {
    return pratos;
  }

  public void setPratos(List<Prato> pratos) {
    this.pratos = pratos;
  }

  public EstadoEncomenda getEstado() {
    return estado;
  }

  public void setEstado(EstadoEncomenda estado) {
    this.estado = estado;
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
    EncomendaRestaurante other = (EncomendaRestaurante) obj;
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
