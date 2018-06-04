package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.dto.FaturaDto;
import pt.tqs.g205.resources.models.PagamentoModel;

@Service
public class PagamentoService {
  @Autowired
  private ClienteService clienteService;
  
  public FaturaDto processarPagamento(PagamentoModel pagamento) {
    Cliente cli = clienteService.getById(pagamento.getCliente());
    return new FaturaDto(cli.getNome(), cli.getNif(), pagamento.getMontante(), 
        pagamento.getEncomenda());
  }
}
