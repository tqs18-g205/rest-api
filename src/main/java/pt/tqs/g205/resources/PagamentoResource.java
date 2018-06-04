package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.dto.FaturaDto;
import pt.tqs.g205.resources.models.PagamentoModel;
import pt.tqs.g205.services.PagamentoService;

/**
 * Controlador REST para expor pagamentos.
 */
@RestController
@RequestMapping(value = "/api/pagamentos")
public class PagamentoResource {
  @Autowired
  private PagamentoService pagamentoService;
  
  /**
   * Endpoint para efetuar pagamentos.
   * @return fatura simplificada.
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<FaturaDto> efetuarPagamento(@RequestBody PagamentoModel pagamento) {
    FaturaDto fatura = pagamentoService.processarPagamento(pagamento);

    return ResponseEntity.ok(fatura);
  }
}
