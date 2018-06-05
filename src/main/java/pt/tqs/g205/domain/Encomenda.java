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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Encomendas.
 */
@Entity
public class Encomenda implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Double total;

  @JsonManagedReference
  @OneToMany(mappedBy = "encomenda")
  private List<PratosPorEncomenda> pratos = new ArrayList<>();

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "tipo_entrega")
  private TipoEntrega tipoEntrega;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @JsonManagedReference
  @OneToMany(mappedBy = "encomenda")
  private List<EstadoEncomendaHora> estados = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "encomenda")
  private List<EncomendaRestaurante> parcelas = new ArrayList<>();

  public Encomenda() {
    super();
  }

  /**
   * Construtor.
   * 
   * @param id id da encomenda.
   * @param tipoEntrega tipo de entrega.
   * @param cliente cliente.
   */
  public Encomenda(Integer id, TipoEntrega tipoEntrega, Cliente cliente) {
    super();
    this.id = id;
    this.tipoEntrega = tipoEntrega;
    this.cliente = cliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<EncomendaRestaurante> getParcelas() {
    return parcelas;
  }

  public void setParcelas(List<EncomendaRestaurante> parcelas) {
    this.parcelas = parcelas;
  }

  public List<PratosPorEncomenda> getPratos() {
    return pratos;
  }

  public void setPratos(List<PratosPorEncomenda> pratos) {
    this.pratos = pratos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public TipoEntrega getTipoEntrega() {
    return tipoEntrega;
  }

  public void setTipoEntrega(TipoEntrega tipoEntrega) {
    this.tipoEntrega = tipoEntrega;
  }

  public List<EstadoEncomendaHora> getEstados() {
    return estados;
  }

  public void setEstados(List<EstadoEncomendaHora> estados) {
    this.estados = estados;
  }
  
  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  
  /**
   * Calcula preco total da encomenda.
   */
  public void calcularPreco() {
    Double sum = 0.0;
    for (PratosPorEncomenda ppe : pratos) {
      Prato prato = ppe.getPrato();
      sum += prato.getPreco() * ppe.getQuantity();
    }
    this.total = sum;
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
    Encomenda other = (Encomenda) obj;
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
