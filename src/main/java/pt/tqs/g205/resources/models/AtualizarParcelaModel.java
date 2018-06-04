package pt.tqs.g205.resources.models;

import java.io.Serializable;

/**
 * Modelo do pedido para atualizar estado de uma encomenda para o restaurante.
 */
public class AtualizarParcelaModel implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer encomenda;
  private Integer estado;
  
  public AtualizarParcelaModel() {
    super();
  }

  /**
   * Construtor.
   * @param encomenda id da encomenda.
   * @param estado id do novo estado.
   */
  public AtualizarParcelaModel(Integer encomenda, Integer estado) {
    super();
    this.encomenda = encomenda;
    this.estado = estado;
  }

  public Integer getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Integer encomenda) {
    this.encomenda = encomenda;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

}
