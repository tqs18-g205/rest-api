package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Tipos de cozinha.
 */
@Entity
public class TipoCozinha implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @JsonBackReference
  @OneToMany(mappedBy = "tipoCozinha")
  private List<Restaurante> restaurantes = new ArrayList<>();

  public TipoCozinha() {
    super();
  }

  /**
   * Constructor.
   * @param id id do tipo de cozinha.
   * @param nome descricao da cozinha.
   */
  public TipoCozinha(Integer id, String nome) {
    super();
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Restaurante> getRestaurantes() {
    return restaurantes;
  }

  public void setRestaurantes(List<Restaurante> restaurantes) {
    this.restaurantes = restaurantes;
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
    TipoCozinha other = (TipoCozinha) obj;
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
