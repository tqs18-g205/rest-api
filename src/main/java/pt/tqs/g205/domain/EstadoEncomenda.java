package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Estado da encomenda.
 */
@Entity
public class EstadoEncomenda implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String descricao;

  @JsonBackReference
  @OneToMany(mappedBy = "estadoEncomenda")
  private List<EstadoEncomendaHora> encomendas = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
  private List<EncomendaRestaurante> parcelas = new ArrayList<>();

  public EstadoEncomenda() {
    super();
  }

  /**
   * Construtor.
   * 
   * @param id id do estado.
   * @param descricao descricao.
   */
  public EstadoEncomenda(Integer id, String descricao) {
    super();
    this.id = id;
    this.descricao = descricao;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<EncomendaRestaurante> getParcelas() {
    return parcelas;
  }

  public void setParcelas(List<EncomendaRestaurante> parcelas) {
    this.parcelas = parcelas;
  }

  public List<EstadoEncomendaHora> getEncomendas() {
    return encomendas;
  }

  public void setEncomendas(List<EstadoEncomendaHora> encomendas) {
    this.encomendas = encomendas;
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
    EstadoEncomenda other = (EstadoEncomenda) obj;
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
