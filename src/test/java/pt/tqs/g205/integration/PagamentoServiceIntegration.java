package pt.tqs.g205.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.dto.FaturaDto;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.resources.models.PagamentoModel;
import pt.tqs.g205.security.ClienteSs;
import pt.tqs.g205.services.PagamentoService;
import pt.tqs.g205.services.UserService;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class PagamentoServiceIntegration {
  @Autowired
  private PagamentoService pagamentoService;
  
  @MockBean
  private UserService userService;
  
  @Autowired
  private ClienteRepository clienteRepo;
  
  private PagamentoModel pagamento;
  private Cliente cli;
  
  /**
   * Setup dos testes.
   */
  @Before
  public void setup() {
    pagamento = new PagamentoModel(1, 25.0, 1);
    cli = clienteRepo.findById(1).get();
    Mockito.when(userService.authenticated())
      .thenReturn(new ClienteSs(cli.getId(), cli.getEmail(), cli.getPasswd()));
  }
  
  @Test
  public void efetuarPagamento() {
    FaturaDto fatura = pagamentoService.processarPagamento(pagamento);
    Assertions.assertThat(fatura).isNotNull();
    Assertions.assertThat(fatura.getNome()).isEqualTo(cli.getNome());
    Assertions.assertThat(fatura.getNif()).isEqualTo(cli.getNif());
    Assertions.assertThat(fatura.getMontante()).isEqualTo(pagamento.getMontante());
    Assertions.assertThat(fatura.getEncomenda()).isEqualTo(pagamento.getEncomenda());
  }
}
