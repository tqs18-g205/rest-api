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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pt.tqs.g205.CommitsApplication;
import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.services.IngredienteService;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CommitsApplication.class)
@AutoConfigureMockMvc
public class IngredienteResourceTest {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private IngredienteService ingredienteService;

  @InjectMocks
  private IngredienteResource ingredienteResource;

  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(ingredienteResource).build();
  }

  @Test
  public void getAll() throws Exception {
    Ingrediente i1 = new Ingrediente(1, "Arroz", 100.0);
    Mockito.when(ingredienteService.getAll()).thenReturn(Collections.singletonList(i1));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredientes"))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].nome").value("Arroz"));
  }
}
