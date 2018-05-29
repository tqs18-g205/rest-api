package pt.tqs.g205.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Morada.
 */
@Entity
public class Morada implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String rua;
  private String localidade;
  private String codigoPostal;
  private String distrito;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  public Morada() {}

  /**
   * Constructor.
   * 
   * @param id id da Morada (autogerado).
   * @param rua rua.
   * @param localidade localidade.
   * @param codigoPostal código zip.
   * @param distrito distrito.
   * @param cliente cliente.
   */
  public Morada(Integer id, String rua, String localidade, String codigoPostal, String distrito,
      Cliente cliente) {
    super();
    this.id = id;
    this.rua = rua;
    this.localidade = localidade;
    this.codigoPostal = codigoPostal;
    this.distrito = distrito;
    this.cliente = cliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
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
    Morada other = (Morada) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


}
