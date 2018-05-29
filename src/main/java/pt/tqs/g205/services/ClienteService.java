package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Morada;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.MoradaRepository;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.security.ClienteSs;
import pt.tqs.g205.services.exceptions.AuthorizationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Lógica de serviços para a entidade Cliente.
 */
@Service
public class ClienteService {
  @Autowired
  private BCryptPasswordEncoder beCryptPasswordEncoder;

  @Autowired
  private ClienteRepository clienteRepo;

  @Autowired
  private MoradaRepository moradaRepo;

  @Autowired
  private UserService userService;

  /**
   * Retorna uma lista com dados genéricos de todos os clientes.
   * 
   * @return lista de todos os clientes.
   */
  public List<Cliente> getAll() {
    return clienteRepo.findAll();
  }

  /**
   * Regista um cliente no servidor e devolve um objeto com a sua descrição.
   * 
   * @param cliente cliente descrito no corpo do request.
   * @return instância de Cliente criada.
   */
  public Cliente registerCliente(RegistoClienteModel cliente) {
    Cliente cli = new Cliente(null, cliente.getNome(),
        beCryptPasswordEncoder.encode(cliente.getPasswd()), cliente.getNif(), cliente.getEmail());
    clienteRepo.saveAll(Arrays.asList(cli));
    List<MoradaModel> models = cliente.getMoradas();
    List<Morada> moradas = new ArrayList<>();
    models.forEach(m -> {
      Morada temp = new Morada(null, m.getRua(), m.getLocalidade(), m.getCodigoPostal(),
          m.getDistrito(), cli);
      moradas.add(temp);
    });
    moradaRepo.saveAll(moradas);
    cli.setMoradas(moradas);
    List<Cliente> persisted = clienteRepo.saveAll(Arrays.asList(cli));
    return persisted.get(0);
  }

  /**
   * Retorna os dados de um cliente.
   * 
   * @param id id do Cliente.
   * @return instância do Cliente.
   * @throws NoSuchElementException se o id não existir na base de dados.
   */
  public Cliente getById(Integer id) {
    ClienteSs client = userService.authenticated();

    if (client == null || !id.equals(client.getId())) {
      throw new AuthorizationException("Access denied");
    }

    Optional<Cliente> obj = clienteRepo.findById(id);

    if (!obj.isPresent()) {
      throw new NoSuchElementException();
    }
    return obj.get();

  }

}
