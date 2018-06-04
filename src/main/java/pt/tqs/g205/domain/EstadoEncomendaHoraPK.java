package pt.tqs.g205.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Chave primaria da tabela de estados de encomenda por hora.
 */
@Embeddable
public class EstadoEncomendaHoraPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "encomenda_id")
  private Integer encomenda;

  @Column(name = "estado_encomenda_id")
  private Integer estado;

  public EstadoEncomendaHoraPK() {}

  /**
   * Construtor.
   * 
   * @param encomenda id da encomenda.
   * @param estado id do estado.
   */
  public EstadoEncomendaHoraPK(Integer encomenda, Integer estado) {
    super();
    this.encomenda = encomenda;
    this.estado = estado;
  }

  public Integer getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Integer encomenda) {
    this.encomenda = encomenda;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((encomenda == null) ? 0 : encomenda.hashCode());
    result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
    EstadoEncomendaHoraPK other = (EstadoEncomendaHoraPK) obj;
    if (encomenda == null) {
      if (other.encomenda != null) {
        return false;
      }
    } else if (!encomenda.equals(other.encomenda)) {
      return false;
    }
    if (estado == null) {
      if (other.estado != null) {
        return false;
      }
    } else if (!estado.equals(other.estado)) {
      return false;
    }
    return true;
  }



}
