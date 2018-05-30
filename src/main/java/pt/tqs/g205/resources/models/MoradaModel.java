package pt.tqs.g205.resources.models;

import java.io.Serializable;

public class MoradaModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private String rua;
  private String localidade;
  private String codigoPostal;
  private String distrito;

  public MoradaModel() {
    super();
  }
  
  /**
   * Constructor.
   * @param rua nome da rua.
   * @param localidade localidade.
   * @param codigoPostal código postal.
   * @param distrito distrito.
   */
  public MoradaModel(String rua, String localidade, String codigoPostal, String distrito) {
    super();
    this.rua = rua;
    this.localidade = localidade;
    this.codigoPostal = codigoPostal;
    this.distrito = distrito;
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

}
