package pt.tqs.g205.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Chave primaria da tabela de pratos por encomenda.
 */
@Embeddable
public class PratosPorEncomendaPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "encomenda_id")
  private Integer encomendaId;

  @Column(name = "prato_id")
  private Integer pratoId;

  public PratosPorEncomendaPK() {}

  /**
   * Construtor.
   * @param encomendaId id da encomenda.
   * @param pratoId id do prato.
   */
  public PratosPorEncomendaPK(Integer encomendaId, Integer pratoId) {
    super();
    this.encomendaId = encomendaId;
    this.pratoId = pratoId;
  }

  public Integer getEncomendaId() {
    return encomendaId;
  }

  public void setEncomendaId(Integer encomendaId) {
    this.encomendaId = encomendaId;
  }

  public Integer getPratoId() {
    return pratoId;
  }

  public void setPratoId(Integer pratoId) {
    this.pratoId = pratoId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((encomendaId == null) ? 0 : encomendaId.hashCode());
    result = prime * result + ((pratoId == null) ? 0 : pratoId.hashCode());
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
    PratosPorEncomendaPK other = (PratosPorEncomendaPK) obj;
    if (encomendaId == null) {
      if (other.encomendaId != null) {
        return false;
      }
    } else if (!encomendaId.equals(other.encomendaId)) {
      return false;
    }
    if (pratoId == null) {
      if (other.pratoId != null) {
        return false;
      }
    } else if (!pratoId.equals(other.pratoId)) {
      return false;
    }
    return true;
  }



}
