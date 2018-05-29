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
public class ClienteRepositoryTest {
  @Autowired
  private ClienteRepository clienteRepo;

  @Autowired
  private MoradaRepository moradaRepo;

  @Test
  public void save() {
    Cliente cli = new Cliente(null, "Chico Matos", "1234", "999999999", "chico@matos.pt");

    Morada morada = new Morada(null, "Rua xpto", "Aveiro", "3810-610", "Aveiro", cli);

    Cliente cliente = clienteRepo.save(cli);
    cliente.setMoradas(Arrays.asList(morada));
    moradaRepo.saveAll(Arrays.asList(morada));
    clienteRepo.saveAll(Arrays.asList(cliente));

    Assertions.assertThat(cliente.getId()).isNotNull();
    Assertions.assertThat(cliente.getId()).isGreaterThan(0);
    Assertions.assertThat(cliente.getMoradas()).isNotNull();
    Assertions.assertThat(cliente.getMoradas()).isNotEmpty();
    Assertions.assertThat(cliente.getMoradas().get(0).getDistrito()).isEqualTo("Aveiro");
  }

  @Test
  public void findById() {
    Cliente cli = new Cliente(null, "Chico Matos", "1234", "999999999", "chico@ua.pt");
    Cliente cliente = clienteRepo.save(cli);

    cliente = clienteRepo.findById(cliente.getId()).get();
    Assertions.assertThat(cliente.getId()).isNotNull();
    Assertions.assertThat(cliente.getId()).isGreaterThan(0);
    Assertions.assertThat(cliente.getMoradas()).isNotNull();
  }

  @Test
  public void findByEmail() {
    Cliente cli = new Cliente(null, "Chico Matos", "1234", "999999999", "chico@tqs.pt");
    Cliente cliente = clienteRepo.save(cli);

    cliente = clienteRepo.findByEmail(cliente.getEmail());
    Assertions.assertThat(cliente.getId()).isNotNull();
    Assertions.assertThat(cliente.getId()).isGreaterThan(0);
    Assertions.assertThat(cliente.getMoradas()).isNotNull();
  }
}
