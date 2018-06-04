package pt.tqs.g205.resources.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EncomendaModel implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer tipoEntrega;
  private Integer cliente;
  private Map<Integer, Integer> pratos = new HashMap<>();

  public EncomendaModel() {
    super();
  }

  public EncomendaModel(Integer tipoEntrega, Integer cliente) {
    super();
    this.tipoEntrega = tipoEntrega;
    this.cliente = cliente;
  }

  public Integer getTipoEntrega() {
    return tipoEntrega;
  }

  public void setTipoEntrega(Integer tipoEntrega) {
    this.tipoEntrega = tipoEntrega;
  }

  public Integer getCliente() {
    return cliente;
  }

  public void setCliente(Integer cliente) {
    this.cliente = cliente;
  }


  public Map<Integer, Integer> getPratos() {
    return pratos;
  }

  public void setPratos(Map<Integer, Integer> pratos) {
    this.pratos = pratos;
  }


}
