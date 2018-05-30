package pt.tqs.g205.resources;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pt.tqs.g205.RestapiApplication;
import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Morada;
import pt.tqs.g205.resources.models.MoradaModel;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.security.JwtUtil;
import pt.tqs.g205.services.ClienteService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestapiApplication.class)
@AutoConfigureMockMvc
public class ClienteResourceTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private JwtUtil jwtUtil;

  @Mock
  private ClienteService clienteService;

  @InjectMocks
  private ClienteResource clienteResource;

  private MoradaModel morada;
  private RegistoClienteModel cliente;
  private Cliente cli;
  private String json;

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
    cli = new Cliente(1, cliente.getNome(), cliente.getPasswd(), cliente.getNif(),
        cliente.getEmail());
    cli.setMoradas(Arrays.asList(new Morada(1, morada.getRua(), morada.getLocalidade(),
        morada.getCodigoPostal(), morada.getDistrito(), cli)));

    ObjectMapper mapper = new ObjectMapper();
    json = mapper.writeValueAsString(cliente);

    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(clienteResource).build();
  }

  @Test
  public void registerCliente() throws Exception {
    Mockito.when(clienteService.registerCliente(cliente)).thenReturn(cli);
    this.mockMvc
        .perform(MockMvcRequestBuilders.post("/api/clientes")
            .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void getClienteById() throws Exception {
    Mockito.when(clienteService.getById(1)).thenReturn(cli);

    String token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.get("/api/clientes/1").header("Authorization", "Bearer " + token))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

}
