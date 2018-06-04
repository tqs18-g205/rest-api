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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.resources.models.PagamentoModel;
import pt.tqs.g205.security.JwtUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PagamentoResourceIntegration {
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private JwtUtil jwtUtil;
  
  @Autowired
  private ClienteRepository clienteRepo;
  
  private String token;
  private Cliente cli;
  private String json;
  
  /**
   * Setup dos testes.
   * @throws JsonProcessingException quando falha o parsing do pagamento.
   */
  @Before
  public void setup() throws JsonProcessingException {
    cli = clienteRepo.findById(1).get();
    PagamentoModel model = new PagamentoModel(1, 25.00, 1);
    ObjectMapper mapper = new ObjectMapper();
    json = mapper.writeValueAsString(model);
    
  }
  
  @Test
  public void efetuarPagamento() throws Exception {
    token = jwtUtil.generateToken(cli.getEmail());
    this.mockMvc.perform(
        MockMvcRequestBuilders.post("/api/pagamentos")
        .header("Authorization", "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
