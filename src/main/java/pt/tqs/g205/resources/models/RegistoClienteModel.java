package pt.tqs.g205.resources.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo do pedido para registo de cliente.
 */
public class RegistoClienteModel implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nome;
  private String passwd;
  private String nif;
  private String email;
  private List<MoradaModel> moradas = new ArrayList<>();

  public RegistoClienteModel() {
    super();
  }

  public RegistoClienteModel(String nome, String passwd, String nif, String email) {
    super();
    this.nome = nome;
    this.passwd = passwd;
    this.nif = nif;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<MoradaModel> getMoradas() {
    return moradas;
  }

  public void setMoradas(List<MoradaModel> moradas) {
    this.moradas = moradas;
  }

}
