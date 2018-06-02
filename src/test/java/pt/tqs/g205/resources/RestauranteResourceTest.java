package pt.tqs.g205.resources;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pt.tqs.g205.RestapiApplication;
import pt.tqs.g205.domain.Restaurante;
import pt.tqs.g205.services.RestauranteService;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestapiApplication.class)
@AutoConfigureMockMvc
public class RestauranteResourceTest {
  @Autowired
  private MockMvc mockMvc;
  
  @Mock
  private RestauranteService restauranteService;
  
  @InjectMocks
  private RestauranteResource restauranteResource;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(restauranteResource).build();
  }
  
  @Test
  public void getRestaurantes() throws Exception {
    Mockito.when(restauranteService.getAll())
      .thenReturn(Collections.singletonList(new Restaurante(1, "Moliceiro", null)));
    
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
  }
  
  @Test
  public void getRestauranteById() throws Exception {
    Mockito.when(restauranteService.getById(1))
      .thenReturn(new Restaurante(1, "Moliceiro", null));
    
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurantes/1"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1));
  }
}
