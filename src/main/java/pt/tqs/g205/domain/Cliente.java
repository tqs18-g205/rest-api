package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Clientes.
 */
@Entity
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String nif;

  @Column(unique = true)
  private String email;

  @JsonIgnore
  private String passwd;

  @JsonManagedReference
  @OneToOne(mappedBy = "cliente")
  private Morada morada;
  
  @JsonBackReference
  @OneToMany(mappedBy = "cliente")
  private List<Reserva> reservas = new ArrayList<>();
  
  @JsonBackReference
  @OneToMany(mappedBy = "cliente")
  private List<Encomenda> encomendas = new ArrayList<>();

  public Cliente() {
    super();
  }

  /**
   * Constructor,
   * 
   * @param id id do Cliente (autogerado pelo Hibernate).
   * @param nome nome do Cliente.
   * @param passwd password do Cliente.
   * @param nif Número de Identificação Fiscal.
   */
  public Cliente(Integer id, String nome, String passwd, String nif, String email) {
    super();
    this.id = id;
    this.nome = nome;
    this.passwd = passwd;
    this.nif = nif;
    this.email = email;
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

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

  public void setReservas(List<Reserva> reservas) {
    this.reservas = reservas;
  }
  
  public Morada getMorada() {
    return morada;
  }

  public void setMorada(Morada morada) {
    this.morada = morada;
  }

  public List<Encomenda> getEncomendas() {
    return encomendas;
  }

  public void setEncomendas(List<Encomenda> encomendas) {
    this.encomendas = encomendas;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
    Cliente other = (Cliente) obj;
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
