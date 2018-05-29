package pt.tqs.g205.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.resources.models.RegistoClienteModel;
import pt.tqs.g205.services.ClienteService;

/**
 * Controlador REST para expôr serviços aos Clientes.
 */
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

  @Autowired
  private ClienteService clienteService;

  /**
   * Endpoint para registar clientes.
   * 
   * @return dados do cliente registado.
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<Cliente> registerCliente(@RequestBody RegistoClienteModel cliente) {
    Cliente cli = clienteService.registerCliente(cliente);

    return ResponseEntity.ok(cli);
  }

  /**
   * Endpoint para obter os dados de um cliente específico.
   * 
   * @param id id do cliente.
   * @return dados do cliente.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
    Cliente cliente = clienteService.getById(id);

    return ResponseEntity.ok(cliente);
  }


}
