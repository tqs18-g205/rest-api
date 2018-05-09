package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Ingredientes por prato.
 */
@Entity
@Table(name = "IngredientesPorPrato")
public class IngredientesPorPrato implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private IngredientesPorPratoPk id;

  @JsonBackReference
  @ManyToOne
  @MapsId("pratoId")
  @JoinColumn(name = "prato_id")
  private Prato prato;

  @JsonManagedReference
  @ManyToOne
  @MapsId("ingredienteId")
  @JoinColumn(name = "ingrediente_id")
  private Ingrediente ingrediente;

  private Double quantidade;

  public IngredientesPorPrato() {}
  
  /**
   * Construtor.
   * @param prato prato.
   * @param ingrediente ingrediente a adicionar.
   * @param quantidade quantidade de ingrediente.
   */
  public IngredientesPorPrato(Prato prato, Ingrediente ingrediente, Double quantidade) {
    super();
    this.id = new IngredientesPorPratoPk(prato.getId(), ingrediente.getId());
    this.prato = prato;
    this.ingrediente = ingrediente;
    this.quantidade = quantidade;
  }



  public void setId(IngredientesPorPratoPk id) {
    this.id = id;
  }

  public Prato getPrato() {
    return prato;
  }

  public void setPrato(Prato prato) {
    this.prato = prato;
  }

  public Ingrediente getIngrediente() {
    return ingrediente;
  }

  public void setIngrediente(Ingrediente ingrediente) {
    this.ingrediente = ingrediente;
  }

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }



  public IngredientesPorPratoPk getId() {
    return id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
    result = prime * result + ((prato == null) ? 0 : prato.hashCode());
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
    IngredientesPorPrato other = (IngredientesPorPrato) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (ingrediente == null) {
      if (other.ingrediente != null) {
        return false;
      }
    } else if (!ingrediente.equals(other.ingrediente)) {
      return false;
    }
    if (prato == null) {
      if (other.prato != null) {
        return false;
      }
    } else if (!prato.equals(other.prato)) {
      return false;
    }
    return true;
  }

}
