package pt.tqs.g205.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ClienteSs implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String email;
  private String passwd;

  public Integer getId() {
    return id;
  }

  public ClienteSs() {}
  
  /**
   * Constructor.
   * @param id id do cliente.
   * @param email email do cliente.
   * @param passwd palavra-chave.
   */
  public ClienteSs(Integer id, String email, String passwd) {
    this.id = id;
    this.email = email;
    this.passwd = passwd;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public String getPassword() {
    return passwd;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
