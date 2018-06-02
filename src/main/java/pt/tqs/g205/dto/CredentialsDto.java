package pt.tqs.g205.dto;

import java.io.Serializable;

/**
 * Modelo que representa pedido de login.
 */
public class CredentialsDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String username;
  private String passwd;

  /**
   * Constructor vazio.
   */
  public CredentialsDto() {
    super();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }


}
