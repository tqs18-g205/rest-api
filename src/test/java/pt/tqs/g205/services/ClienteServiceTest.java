package pt.tqs.g205.services;

import static org.mockito.ArgumentMatchers.any;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Morada;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.EncomendaRepository;
import pt.tqs.g205.repositories.MoradaRepository;
import pt.tqs.g205.repositories.PratoRepository;
import pt.tqs.g205.repositories.ReservaRepository;
import pt.tqs.g205.repositories.RestauranteRepository;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.security.ClienteSs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClienteServiceTest {
  @MockBean
  private EncomendaRestauranteService encomendaRestauranteService;
  
  @MockBean
  private EncomendaRepository encomendaRepo;
  
  @Autowired
  private ClienteService clienteService;
  
  @MockBean
  private RestauranteRepository restauranteRepo;
  
  @MockBean
  private PratoRepository pratoRepo;

  @MockBean
  private ClienteRepository clienteRepo;

  @MockBean
  private MoradaRepository moradaRepo;
  
  @MockBean
  private ReservaRepository reservaRepo;

  @MockBean
  private UserService userService;

  private Cliente cli;

  private List<Cliente> clientes;

  private MoradaModel model;

  private RegistoClienteModel clienteModel;

  private Morada morada;

  /**
   * Setup dos testes.
   */
  @SuppressWarnings("unchecked")
  @Before
  public void setup() {
    morada = new Morada(1, "Rua xpto", "Gloria", "3810-555", "Aveiro", cli, null);
    clienteModel = new RegistoClienteModel("Rua xpto", "Gloria", "3810-555", "Aveiro");
    model = new MoradaModel("Rua xpto", "Gloria", "3810-555", "Aveiro");
    clienteModel.setMorada(model);
    cli = new Cliente(1, "Chico Matos", "1234", "999999999", "chico@matos.pt");
    cli.setMorada(morada);
    clientes = new ArrayList<>();
    clientes.add(cli);

    Mockito.when(clienteRepo.findById(1)).thenReturn(Optional.of(cli));

    Mockito.when(clienteRepo.findAll()).thenReturn(Collections.singletonList(cli));

    Mockito.when(clienteRepo.saveAll(any(Iterable.class))).thenReturn(clientes);

    Mockito.when(moradaRepo.saveAll(any(Iterable.class)))
        .thenReturn(Collections.singletonList(morada));

    Mockito.when(userService.authenticated())
        .thenReturn(new ClienteSs(1, "chico@matos.pt", "1234"));
  }

  @Test
  public void registerCliente() {
    Cliente cliente = clienteService.registerCliente(clienteModel);

    Assertions.assertThat(cliente.getId()).isEqualTo(1);
    Assertions.assertThat(cliente.getMorada()).isNotNull();
  }

  @Test
  public void getById() {
    Cliente cliente = clienteService.getById(1);

    Assertions.assertThat(cliente.getId()).isEqualTo(1);
    Assertions.assertThat(cliente.getMorada()).isNotNull();
  }

  @Test
  public void getAll() {
    List<Cliente> listagem = clienteService.getAll();

    Assertions.assertThat(listagem).isNotNull();
    Assertions.assertThat(listagem).isNotEmpty();
    Assertions.assertThat(listagem.get(0)).isNotNull();
    Assertions.assertThat(listagem.get(0).getId()).isEqualTo(1);
    Assertions.assertThat(listagem.get(0).getMorada()).isNotNull();
  }
}
