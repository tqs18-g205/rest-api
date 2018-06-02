package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * Restaurantes.
 */
@Entity
public class Restaurante implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @JsonManagedReference
  @ManyToOne
  private TipoCozinha tipoCozinha;

  @JsonManagedReference
  @OneToMany(mappedBy = "restaurante")
  private List<Prato> pratos = new ArrayList<>();

  @JsonManagedReference
  @ManyToMany
  @JoinTable(name = "Restaurante_Tipos_Entrega", joinColumns = @JoinColumn(name = "restaurante_id"),
      inverseJoinColumns = @JoinColumn(name = "tipo_entrega_id"))
  private List<TipoEntrega> tiposEntrega = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "restaurante")
  private List<Reserva> reservas = new ArrayList<>();
  
  @JsonManagedReference
  @OneToMany(mappedBy = "restaurante")
  private List<Morada> moradas = new ArrayList<>();

  public Restaurante() {}

  /**
   * Constructor.
   * @param id id do restaurante.
   * @param nome nome do restaurante.
   * @param tipoCozinha tipo de culinária.
   */
  public Restaurante(Integer id, String nome, TipoCozinha tipoCozinha) {
    super();
    this.id = id;
    this.nome = nome;
    this.tipoCozinha = tipoCozinha;
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

  public List<Prato> getPratos() {
    return pratos;
  }

  public void setPratos(List<Prato> pratos) {
    this.pratos = pratos;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

  public void setReservas(List<Reserva> reservas) {
    this.reservas = reservas;
  }

  public List<TipoEntrega> getTiposEntrega() {
    return tiposEntrega;
  }

  public void setTiposEntrega(List<TipoEntrega> tiposEntrega) {
    this.tiposEntrega = tiposEntrega;
  }

  public TipoCozinha getTipoCozinha() {
    return tipoCozinha;
  }

  public void setTipoCozinha(TipoCozinha tipoCozinha) {
    this.tipoCozinha = tipoCozinha;
  }

  public List<Morada> getMoradas() {
    return moradas;
  }

  public void setMoradas(List<Morada> moradas) {
    this.moradas = moradas;
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
    Restaurante other = (Restaurante) obj;
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
