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

import pt.tqs.g205.RestapiApplication;
import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.services.CategoriaPratoService;

import java.util.Collections;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestapiApplication.class)
@AutoConfigureMockMvc
public class CategoriaPratoResourceTest {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private CategoriaPratoService categoriaService;

  @InjectMocks
  private CategoriaPratoResource categoriaResource;

  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(categoriaResource).build();
  }

  @Test
  public void getAll() throws Exception {
    Mockito.when(categoriaService.getAll())
        .thenReturn(Collections.singletonList(new CategoriaPrato(1, "Italiano")));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/categorias/pratos"))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].nome").value("Italiano"));
  }
}
