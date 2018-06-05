package pt.tqs.g205.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer cliente;
  private String token;
  
  public LoginDto() {
    super();
  }

  public LoginDto(Integer cliente, String token) {
    super();
    this.cliente = cliente;
    this.token = token;
  }

  public Integer getCliente() {
    return cliente;
  }

  public void setCliente(Integer cliente) {
    this.cliente = cliente;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
  
  

}
