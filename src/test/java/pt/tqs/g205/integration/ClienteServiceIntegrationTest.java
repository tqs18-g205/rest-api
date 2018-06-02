package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Morada;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.services.ClienteService;
import pt.tqs.g205.services.exceptions.AuthorizationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@RunWith(SpringRunner.class)
public class ClienteServiceIntegrationTest {

  @Autowired
  private ClienteService clienteService;

  private Cliente cli;

  private List<Cliente> clientes;

  private MoradaModel model;

  private RegistoClienteModel clienteModel;

  private Morada morada;

  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    morada = new Morada(1, "Rua xpto", "Gloria", "3810-555", "Aveiro", cli, null);
    clienteModel = new RegistoClienteModel("Rua xpto", "Gloria", "3810-555", "Aveiro");
    model = new MoradaModel("Rua xpto", "Gloria", "3810-555", "Aveiro");
    clienteModel.setMoradas(Arrays.asList(model));
    cli = new Cliente(1, "Chico Matos", "1234", "999999999", "chico@matos.pt");
    cli.setMoradas(Arrays.asList(morada));
    clientes = new ArrayList<>();
    clientes.add(cli);
  }

  @Test
  public void registerCliente() {
    Cliente cliente = clienteService.registerCliente(clienteModel);

    Assertions.assertThat(cliente.getId()).isGreaterThan(0);
    Assertions.assertThat(cliente.getMoradas()).isNotNull();
    Assertions.assertThat(cliente.getMoradas()).isNotEmpty();
  }

  @Test(expected = AuthorizationException.class)
  public void getByIdBlocked() {
    clienteService.getById(1);
  }

  @Test
  public void getAll() {
    List<Cliente> listagem = clienteService.getAll();

    Assertions.assertThat(listagem).isNotNull();
    Assertions.assertThat(listagem).isNotEmpty();
    Assertions.assertThat(listagem.get(0)).isNotNull();
    Assertions.assertThat(listagem.get(0).getId()).isEqualTo(1);
    Assertions.assertThat(listagem.get(0).getMoradas()).isNotNull();
  }
}
