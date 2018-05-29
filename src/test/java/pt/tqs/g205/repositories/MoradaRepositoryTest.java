package pt.tqs.g205.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Morada;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MoradaRepositoryTest {
  @Autowired
  private MoradaRepository moradaRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  @Test
  public void save() {
    Cliente cli = new Cliente(null, "John Doe", "1234", "999999999", "john@doe.com");

    Morada morada = new Morada(null, "Rua xpto", "Gloria", "3810-610", "Aveiro", cli);

    Cliente cliente = clienteRepo.save(cli);
    cliente.setMoradas(Arrays.asList(morada));
    moradaRepo.saveAll(Arrays.asList(morada));
    clienteRepo.saveAll(Arrays.asList(cliente));

    Assertions.assertThat(morada.getId()).isNotNull();
    Assertions.assertThat(morada.getId()).isGreaterThan(0);
    Assertions.assertThat(morada.getCliente()).isNotNull();
    Assertions.assertThat(morada.getCliente().getId()).isNotNull();
    Assertions.assertThat(morada.getCliente().getId()).isGreaterThan(0);
  }

  @Test
  public void findById() {
    Cliente cli = new Cliente(null, "John Doe", "1234", "999999999", "john@doe.pt");

    Morada morada = new Morada(null, "Rua xpto", "Aveiro", "3810-610", "Aveiro", cli);

    Cliente cliente = clienteRepo.save(cli);
    cliente.setMoradas(Arrays.asList(morada));
    moradaRepo.saveAll(Arrays.asList(morada));
    clienteRepo.saveAll(Arrays.asList(cliente));

    Morada persisted = moradaRepo.findById(morada.getId()).get();
    Assertions.assertThat(persisted).isNotNull();
    Assertions.assertThat(persisted).isEqualTo(morada);
  }
}
