package pt.tqs.g205.resources.models;

import java.io.Serializable;

/**
 * Modelo usado para representar a Reserva num request.
 */
public class ReservaModel implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer cliente;
  private Integer restaurante;
  private String data;
  private String hora;

  public ReservaModel() {
    super();
  }

  /**
   * Constructor.
   * @param cliente id do cliente.
   * @param restaurante id do restaurante.
   * @param data data da reserva.
   * @param hora hora da reserva.
   */
  public ReservaModel(Integer cliente, Integer restaurante, String data, String hora) {
    super();
    this.cliente = cliente;
    this.restaurante = restaurante;
    this.data = data;
    this.hora = hora;
  }

  public Integer getCliente() {
    return cliente;
  }

  public void setCliente(Integer cliente) {
    this.cliente = cliente;
  }

  public Integer getRestaurante() {
    return restaurante;
  }

  public void setRestaurante(Integer restaurante) {
    this.restaurante = restaurante;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }



}
