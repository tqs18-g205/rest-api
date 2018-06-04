package pt.tqs.g205.dto;

import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.domain.TipoEntrega;

import java.io.Serializable;

/**
 * Representacao das encomendas nos restaurantes para resposta da api.
 */
public class EncomendaRestauranteDto implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Integer id;
  private TipoEntrega tipoEntrega;
  private EstadoEncomenda estado;
  
  /**
   * Construtor.
   * @param id id da parcela.
   * @param tipoEntrega tipo de entrega.
   * @param estado estado.
   */
  public EncomendaRestauranteDto(Integer id, TipoEntrega tipoEntrega, EstadoEncomenda estado) {
    super();
    this.id = id;
    this.tipoEntrega = tipoEntrega;
    this.estado = estado;
  }

  public EncomendaRestauranteDto() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TipoEntrega getTipoEntrega() {
    return tipoEntrega;
  }

  public void setTipoEntrega(TipoEntrega tipoEntrega) {
    this.tipoEntrega = tipoEntrega;
  }

  public EstadoEncomenda getEstado() {
    return estado;
  }

  public void setEstado(EstadoEncomenda estado) {
    this.estado = estado;
  }
}
