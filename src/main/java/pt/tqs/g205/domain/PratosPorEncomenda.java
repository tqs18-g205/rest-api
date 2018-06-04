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
 * Representa os pratos encomendados numa encomenda.
 */
@Entity
@Table(name = "PratosPorEncomenda")
public class PratosPorEncomenda implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private PratosPorEncomendaPk id;

  @JsonBackReference
  @ManyToOne
  @MapsId("encomendaId")
  @JoinColumn(name = "encomenda_id")
  private Encomenda encomenda;

  @JsonManagedReference
  @ManyToOne
  @MapsId("pratoId")
  @JoinColumn(name = "prato_id")
  private Prato prato;

  private Integer quantity;

  public PratosPorEncomenda() {}

  /**
   * Construtor.
   * @param encomenda encomenda.
   * @param prato prato.
   * @param quantity quantidade encomendada.
   */
  public PratosPorEncomenda(Encomenda encomenda, Prato prato, Integer quantity) {
    super();
    this.encomenda = encomenda;
    this.prato = prato;
    this.id = new PratosPorEncomendaPk(encomenda.getId(), prato.getId());
    this.quantity = quantity;
  }

  public PratosPorEncomendaPk getId() {
    return id;
  }

  public void setId(PratosPorEncomendaPk id) {
    this.id = id;
  }

  public Encomenda getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Encomenda encomenda) {
    this.encomenda = encomenda;
  }

  public Prato getPrato() {
    return prato;
  }

  public void setPrato(Prato prato) {
    this.prato = prato;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((encomenda == null) ? 0 : encomenda.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    PratosPorEncomenda other = (PratosPorEncomenda) obj;
    if (encomenda == null) {
      if (other.encomenda != null) {
        return false;
      }
    } else if (!encomenda.equals(other.encomenda)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
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
