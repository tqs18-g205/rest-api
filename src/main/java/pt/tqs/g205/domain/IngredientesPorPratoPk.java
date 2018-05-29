package pt.tqs.g205.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Chave primaria da entidade IngredientePorPrato.
 */
@Embeddable
public class IngredientesPorPratoPk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "prato_id")
  private Integer pratoId;

  @Column(name = "ingrediente_id")
  private Integer ingredienteId;

  public IngredientesPorPratoPk() {}

  /**
   * Construtor.
   * 
   * @param pratoId id do prato.
   * @param ingredienteId id do ingrediente.
   */
  public IngredientesPorPratoPk(Integer pratoId, Integer ingredienteId) {
    super();
    this.pratoId = pratoId;
    this.ingredienteId = ingredienteId;
  }

  public Integer getPratoId() {
    return pratoId;
  }

  public void setPratoId(Integer pratoId) {
    this.pratoId = pratoId;
  }

  public Integer getIngredienteId() {
    return ingredienteId;
  }

  public void setIngredienteId(Integer ingredienteId) {
    this.ingredienteId = ingredienteId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ingredienteId == null) ? 0 : ingredienteId.hashCode());
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
    IngredientesPorPratoPk other = (IngredientesPorPratoPk) obj;
    if (ingredienteId == null) {
      if (other.ingredienteId != null) {
        return false;
      }
    } else if (!ingredienteId.equals(other.ingredienteId)) {
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

  @Override
  public String toString() {
    return "IngredientesPorPratoPk [pratoId=" + pratoId + ", ingredienteId=" + ingredienteId + "]";
  }


}
