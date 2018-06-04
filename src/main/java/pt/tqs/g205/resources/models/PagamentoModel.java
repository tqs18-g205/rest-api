package pt.tqs.g205.resources.models;

import java.io.Serializable;

/**
 * Modelo de pedido para pagamento.
 */
public class PagamentoModel implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer cliente;
  private Double montante;
  private Integer encomenda;
  
  public PagamentoModel() {
    super();
  }

  /**
   * Construtor.
   * @param cliente id do cliente.
   * @param montante montante.
   * @param encomenda id da encomenda. 
   */
  public PagamentoModel(Integer cliente, Double montante, Integer encomenda) {
    super();
    this.cliente = cliente;
    this.montante = montante;
    this.encomenda = encomenda;
  }

  public Integer getCliente() {
    return cliente;
  }

  public void setCliente(Integer cliente) {
    this.cliente = cliente;
  }

  public Double getMontante() {
    return montante;
  }

  public void setMontante(Double montante) {
    this.montante = montante;
  }

  public Integer getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Integer encomenda) {
    this.encomenda = encomenda;
  }
  
  
}
