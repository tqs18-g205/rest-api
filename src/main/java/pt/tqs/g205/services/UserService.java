package pt.tqs.g205.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pt.tqs.g205.security.ClienteSS;

@Service
public class UserService {
  public ClienteSS authenticated() {
    try {
      return (ClienteSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } catch (Exception e) {
      return null;
    }
  }
}
