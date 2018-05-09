package pt.tqs.g205.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Prato implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double preco;
  private Double calorias;
  private String imagem;

  @JsonManagedReference
  @ManyToMany
  @JoinTable(name = "Pratos_Categorias", joinColumns = @JoinColumn(name = "prato_id"),
      inverseJoinColumns = @JoinColumn(name = "categoria_id"))
  private List<CategoriaPrato> categorias = new ArrayList<>();

  public Prato() {}

  public Prato(Integer id, String nome, Double preco, String imagem) {
    super();
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.imagem = imagem;
    this.calorias = 0.0;
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public Double getCalorias() {
    return calorias;
  }

  public void setCalorias(Double calorias) {
    this.calorias = calorias;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
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

  public List<CategoriaPrato> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<CategoriaPrato> categorias) {
    this.categorias = categorias;
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
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Prato other = (Prato) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
