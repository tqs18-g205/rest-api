package pt.tqs.g205.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.security.JwtUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ClienteResourceIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private ClienteRepository clienteRepo;

  private MoradaModel morada;
  private RegistoClienteModel cliente;
  private Cliente cli;
  private String json;
  private String token;

  /**
   * Setup dos testes.
   * 
   * @throws Exception if file cannot be converted to json.
   */
  @Before
  public void setup() throws Exception {
    morada = new MoradaModel("Rua xpto", "Gloria", "3810-456", "Aveiro");
    cliente = new RegistoClienteModel("Chico", "1234", "999999888", "john@doe.pt");
    cliente.setMoradas(Arrays.asList(morada));
    cli = clienteRepo.findById(1).get();

    ObjectMapper mapper = new ObjectMapper();
    json = mapper.writeValueAsString(cliente);

    token = jwtUtil.generateToken(cli.getEmail());

  }

  @Test
  public void registerCliente() throws Exception {

    this.mockMvc
        .perform(MockMvcRequestBuilders.post("/api/clientes")
            .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void getClienteById() throws Exception {

    this.mockMvc.perform(
        MockMvcRequestBuilders.get("/api/clientes/1").header("Authorization", "Bearer " + token))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void accessDenied() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes/1"))
        .andExpect(MockMvcResultMatchers.status().isForbidden());
  }

}
