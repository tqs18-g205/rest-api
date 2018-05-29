package pt.tqs.g205.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pt.tqs.g205.security.ClienteSs;

@Service
public class UserService {
  /**
   * Verifica se o utilizador está autenticado.
   * @return instancia de ClienteSs.
   */
  public ClienteSs authenticated() {
    try {
      return (ClienteSs) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } catch (Exception exc) {
      return null;
    }
  }
}
