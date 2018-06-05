package pt.tqs.g205.resources.models;

import java.io.Serializable;

/**
 * Modelo do pedido para atualizar estado de uma encomenda para o restaurante.
 */
public class AtualizarParcelaModel implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer estado;
  
  public AtualizarParcelaModel() {
    super();
  }

  /**
   * Construtor.
   * @param estado id do novo estado.
   */
  public AtualizarParcelaModel(Integer estado) {
    super();
    this.estado = estado;
  }


  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

}
