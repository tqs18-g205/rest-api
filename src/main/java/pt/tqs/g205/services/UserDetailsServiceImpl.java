package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.security.ClienteSs;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private ClienteRepository repo;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Cliente cli = repo.findByEmail(username);

    if (cli == null) {
      throw new UsernameNotFoundException(username);
    }

    return new ClienteSs(cli.getId(), cli.getEmail(), cli.getPasswd());
  }

}
