package pt.tqs.g205.resources;

import java.util.Collections;
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
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.services.PratoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestapiApplication.class)
@AutoConfigureMockMvc
public class PratoResourceTest {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private PratoService pratoService;

  @InjectMocks
  private PratoResource pratoResource;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(pratoResource).build();
  }

  @Test
  public void getAll() throws Exception {
    Prato p1 = new Prato(1, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg");
    Mockito.when(pratoService.getAll()).thenReturn(Collections.singletonList(p1));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/pratos"))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("@.[0].nome").value("Arroz de pato"));
  }

}
