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
import pt.tqs.g205.domain.TipoEntrega;
import pt.tqs.g205.services.TipoEntregaService;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestapiApplication.class)
@AutoConfigureMockMvc
public class TipoEntregaResourceTest {
  @Autowired
  private MockMvc mockMvc;
  
  @Mock
  private TipoEntregaService tipoEntregaService;
  
  @InjectMocks
  private TipoEntregaResource tipoEntregaResource;
  
  /**
   * Setup de testes.
   */
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(tipoEntregaResource).build();
  }
  
  @Test
  public void getAll() throws Exception {
    Mockito.when(tipoEntregaService.getAll())
      .thenReturn(Collections.singletonList(new TipoEntrega(1, "Takeaway")));
    
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tiposentrega"))
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
      .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
  }
}
