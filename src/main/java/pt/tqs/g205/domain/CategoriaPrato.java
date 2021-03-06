package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Categorias de pratos.
 */
@Entity
public class CategoriaPrato implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true)
  private String nome;

  @JsonBackReference
  @ManyToMany(mappedBy = "categorias")
  private List<Prato> pratos = new ArrayList<>();

  public CategoriaPrato() {}

  /**
   * Construtor.
   * 
   * @param id id da categoria.
   * @param name nome do prato.
   */
  public CategoriaPrato(Integer id, String name) {
    super();
    this.id = id;
    this.nome = name;
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

  public void setNome(String name) {
    this.nome = name;
  }

  public List<Prato> getPratos() {
    return pratos;
  }

  public void setPratos(List<Prato> pratos) {
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
    CategoriaPrato other = (CategoriaPrato) obj;
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
