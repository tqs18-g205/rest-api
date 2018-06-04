package pt.tqs.g205.integration;

import com.fasterxml.jackson.databind.ObjectMapper;

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
import pt.tqs.g205.resources.models.EncomendaModel;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.resources.models.ReservaModel;
import pt.tqs.g205.security.JwtUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
  private ReservaModel reservaModel;
  private String reservaJson;
  private EncomendaModel encomendaModel;
  private String encomendaJson;

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
    
    reservaModel = new ReservaModel(1,1, "31-12-2018", "18:30");
    encomendaModel = new EncomendaModel(1,1);
    Map<Integer, Integer> pratos = new HashMap<>();
    pratos.put(1, 1);
    pratos.put(2, 1);
    pratos.put(7, 1);
    encomendaModel.setPratos(pratos);

    ObjectMapper mapper = new ObjectMapper();
    json = mapper.writeValueAsString(cliente);
    reservaJson = mapper.writeValueAsString(reservaModel);
    encomendaJson = mapper.writeValueAsString(encomendaModel);

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
  
  @Test
  public void fazerReserva() throws Exception {
    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.post("/api/clientes/1/reservas")
        .header("Authorization", "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON_UTF8).content(reservaJson))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
  
  @Test
  public void getReservasCliente() throws Exception {
    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.get("/api/clientes/1/reservas")
        .header("Authorization", "Bearer " + token))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void fazerEncomenda() throws Exception {
    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.post("/api/clientes/1/encomendas")
        .header("Authorization", "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON_UTF8).content(encomendaJson))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
  
  @Test
  public void getEncomendasCliente() throws Exception {
    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.get("/api/clientes/1/encomendas")
        .header("Authorization", "Bearer " + token))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
  
  @Test
  public void getEncomenda() throws Exception {
    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.get("/api/clientes/1/encomendas/1")
        .header("Authorization", "Bearer " + token))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
  
}
