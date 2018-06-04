package pt.tqs.g205.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RestauranteResourceIntegrationTest {
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  public void getRestaurantes() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
  }
  
  @Test
  public void getRestauranteById() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes/1"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1));
  }
  
  @Test
  public void getReservas() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes/1/reservas"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
  }
  
  @Test
  public void getEncomendas() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes/1/encomendas"))
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
    .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
  }
  
  @Test
  public void getEncomenda() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes/1/encomendas/1"))
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
    .andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1));
  }
}
