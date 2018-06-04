package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * Estados da encomenda por data e hora.
 */
@Entity
public class EstadoEncomendaHora implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private EstadoEncomendaHoraPk id;

  @JsonBackReference
  @ManyToOne
  @MapsId("encomenda")
  @JoinColumn(name = "encomenda_id")
  private Encomenda encomenda;

  @JsonManagedReference
  @ManyToOne
  @MapsId("estado")
  @JoinColumn(name = "estado_encomenda_id")
  private EstadoEncomenda estadoEncomenda;

  private LocalDate data;
  private LocalTime hora;

  public EstadoEncomendaHora() {
    super();
  }

  /**
   * Construtor.
   * 
   * @param encomenda encomenda.
   * @param estadoEncomenda estado.
   * @param data data.
   * @param hora hora.
   */
  public EstadoEncomendaHora(Encomenda encomenda, EstadoEncomenda estadoEncomenda, LocalDate data,
      LocalTime hora) {
    super();
    this.encomenda = encomenda;
    this.estadoEncomenda = estadoEncomenda;
    this.data = data;
    this.hora = hora;
    this.id = new EstadoEncomendaHoraPk(encomenda.getId(), estadoEncomenda.getId());
  }



  public LocalTime getHora() {
    return hora;
  }

  public void setHora(LocalTime hora) {
    this.hora = hora;
  }



  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public EstadoEncomendaHoraPk getId() {
    return id;
  }

  public void setId(EstadoEncomendaHoraPk id) {
    this.id = id;
  }

  public Encomenda getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Encomenda encomenda) {
    this.encomenda = encomenda;
  }

  public EstadoEncomenda getEstadoEncomenda() {
    return estadoEncomenda;
  }

  public void setEstadoEncomenda(EstadoEncomenda estadoEncomenda) {
    this.estadoEncomenda = estadoEncomenda;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((encomenda == null) ? 0 : encomenda.hashCode());
    result = prime * result + ((estadoEncomenda == null) ? 0 : estadoEncomenda.hashCode());
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
    EstadoEncomendaHora other = (EstadoEncomendaHora) obj;
    if (encomenda == null) {
      if (other.encomenda != null) {
        return false;
      }
    } else if (!encomenda.equals(other.encomenda)) {
      return false;
    }
    if (estadoEncomenda == null) {
      if (other.estadoEncomenda != null) {
        return false;
      }
    } else if (!estadoEncomenda.equals(other.estadoEncomenda)) {
      return false;
    }
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
