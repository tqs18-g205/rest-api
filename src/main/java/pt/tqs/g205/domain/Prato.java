package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Prato.
 */
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

  @JsonManagedReference
  @OneToMany(mappedBy = "ingrediente")
  private List<IngredientesPorPrato> ingredientes = new ArrayList<>();
  
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "restaurante_id")
  private Restaurante restaurante;
  
  @JsonBackReference
  @OneToMany(mappedBy = "prato")
  private List<PratosPorEncomenda> encomendas = new ArrayList<>();

  public Prato() {}

  /**
   * Constructor.
   * 
   * @param id id do prato.
   * @param nome nome do prato.
   * @param preco preco do prato.
   * @param imagem url para imagem descritiva do prato.
   */
  public Prato(Integer id, String nome, Double preco, String imagem, Restaurante restaurante) {
    super();
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.imagem = imagem;
    this.calorias = 0.0;
    this.restaurante = restaurante;
  }

  /**
   * Calcular calorias totais do prato.
   * 
   * @return calorias totais.
   */
  public Double calcularCalorias() {
    Double result = 0.0;

    if (ingredientes == null) {
      return result;
    }

    for (IngredientesPorPrato i : ingredientes) {
      result += i.getQuantidade() / 100.0 * i.getIngrediente().getCalorias();
    }

    return result;
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
  
  

  public List<PratosPorEncomenda> getEncomendas() {
    return encomendas;
  }

  public void setEncomendas(List<PratosPorEncomenda> encomendas) {
    this.encomendas = encomendas;
  }

  public Restaurante getRestaurante() {
    return restaurante;
  }

  public void setRestaurante(Restaurante restaurante) {
    this.restaurante = restaurante;
  }

  public List<CategoriaPrato> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<CategoriaPrato> categorias) {
    this.categorias = categorias;
  }

  public List<IngredientesPorPrato> getIngredientes() {
    return ingredientes;
  }

  /**
   * Atribui ingredientes ao prato e calcula calorias totais.
   * 
   * @param ingredientes lista de ingredientes.
   */
  public void setIngredientes(List<IngredientesPorPrato> ingredientes) {
    this.ingredientes = ingredientes;
    if (ingredientes != null) {
      this.calorias = calcularCalorias();
    }
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
    Prato other = (Prato) obj;
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
