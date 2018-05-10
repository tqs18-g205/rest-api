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
 * Ingredientes.
 */
@Entity
public class Ingrediente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double calorias;

  @JsonBackReference
  @OneToMany(mappedBy = "prato")
  private List<IngredientesPorPrato> pratos = new ArrayList<>();

  public Ingrediente() {}
  
  /**
   * Construtor.
   * @param id id do ingrediente.
   * @param nome nome do ingrediente.
   * @param calorias calorias por 100g de ingrediente.
   */
  public Ingrediente(Integer id, String nome, Double calorias) {
    super();
    this.id = id;
    this.nome = nome;
    this.calorias = calorias;
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

  public Double getCalorias() {
    return calorias;
  }

  public void setCalorias(Double calorias) {
    this.calorias = calorias;
  }

  public List<IngredientesPorPrato> getPratos() {
    return pratos;
  }

  public void setPratos(List<IngredientesPorPrato> pratos) {
    this.pratos = pratos;
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
    Ingrediente other = (Ingrediente) obj;
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
