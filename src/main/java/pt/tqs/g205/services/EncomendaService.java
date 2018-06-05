package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.EncomendaRestaurante;
import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.domain.EstadoEncomendaHora;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.domain.PratosPorEncomenda;
import pt.tqs.g205.domain.TipoEntrega;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.EncomendaRepository;
import pt.tqs.g205.repositories.EstadoEncomendaHoraRepository;
import pt.tqs.g205.repositories.EstadoEncomendaRepository;
import pt.tqs.g205.repositories.PratoRepository;
import pt.tqs.g205.repositories.PratosPorEncomendaRepository;
import pt.tqs.g205.repositories.TipoEntregaRepository;
import pt.tqs.g205.resources.models.EncomendaModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class EncomendaService {

  @Autowired
  private EstadoEncomendaHoraRepository estadoEncomendaHoraRepo;
  
  @Autowired
  private EncomendaRepository encomendaRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private TipoEntregaService tipoEntregaService;

  @Autowired
  private TipoEntregaRepository tipoEntregaRepo;

  @Autowired
  private PratoRepository pratoRepo;

  @Autowired
  private PratoService pratoService;

  @Autowired
  private EstadoEncomendaService estadoEncomendaService;
  
  @Autowired
  private EncomendaRestauranteService encomendaRestauranteService;

  @Autowired
  private EstadoEncomendaRepository estadoEncomendaRepo;

  @Autowired
  private EstadoEncomendaHoraRepository eehRepo;

  @Autowired
  private PratosPorEncomendaRepository ppeRepo;

  /**
   * Obter a lista de todas as encomendas.
   * @return lista de encomendas.
   */
  public List<Encomenda> getAll() {
    List<Encomenda> encomendas = encomendaRepo.findAll();

    encomendas.forEach(e -> {
      Iterator<PratosPorEncomenda> it = e.getPratos().iterator();

      while (it.hasNext()) {
        Prato pr = it.next().getPrato();
        pr.setIngredientes(null);
        pr.setRestaurante(null);

      }
    });

    return encomendas;
  }

  /**
   * Obter as encomendas de um cliente.
   * @param clienteId id do cliente.
   * @return lista das encomendas do cliente.
   * @throws NoSuchElementException se o cliente nao existir.
   */
  public List<Encomenda> getByClienteId(Integer clienteId) {
    List<Encomenda> encomendas = encomendaRepo.getByClienteId(clienteId);

    if (encomendas == null || encomendas.isEmpty()) {
      throw new NoSuchElementException();
    }

    encomendas.forEach(e -> {
      Iterator<PratosPorEncomenda> it = e.getPratos().iterator();

      while (it.hasNext()) {
        PratosPorEncomenda ppe = it.next();
        ppe.setId(null);
        Prato pr = ppe.getPrato();
        pr.setIngredientes(null);
        pr.setRestaurante(null);
      }

      Iterator<EstadoEncomendaHora> estadosIt = e.getEstados().iterator();

      while (estadosIt.hasNext()) {
        EstadoEncomendaHora eeh = estadosIt.next();
        eeh.setId(null);
      }

      e.setCliente(null);
    });

    return encomendas;
  }

  /**
   * Metodo para fazer uma encomenda.
   * @param cliente id do cliente.
   * @param encomenda detalhes da encomenda.
   * @return encomenda.
   */
  public Encomenda fazerEncomenda(Integer cliente, EncomendaModel encomenda) {

    Cliente cli = clienteService.getById(cliente);
    final TipoEntrega entrega = tipoEntregaService.getById(encomenda.getTipoEntrega());
    final EstadoEncomenda estado = estadoEncomendaService.getById(1);

    Encomenda enc = encomendaRepo.save(new Encomenda(null, entrega, cli));

    cli.getEncomendas().add(enc);
    clienteRepo.save(cli);
    entrega.getEncomendas().add(enc);
    tipoEntregaRepo.save(entrega);

    EstadoEncomendaHora eeh =
        new EstadoEncomendaHora(enc, estado, LocalDate.now(), LocalTime.now());
    eehRepo.save(eeh);
    estado.getEncomendas().add(eeh);
    estadoEncomendaRepo.save(estado);
    enc.getEstados().add(eeh);

    List<Prato> pratos = new ArrayList<>();

    encomenda.getPratos().keySet().forEach(pratoId -> pratos.add(
        pratoService.getPratoById(pratoId))
    );

    List<PratosPorEncomenda> pratosEnc = new ArrayList<>();
    
    pratos.forEach(prato -> {
      PratosPorEncomenda ppe = new PratosPorEncomenda(enc, prato, 
          encomenda.getPratos().get(prato.getId()));
      pratosEnc.add(ppe);
      prato.getEncomendas().add(ppe);
    });

    enc.setPratos(pratosEnc);
    ppeRepo.saveAll(pratosEnc);
    pratoRepo.saveAll(pratos);
    enc.calcularPreco();
    Encomenda resultado = encomendaRepo.save(enc);
    
        
    encomendaRestauranteService.criarParcelas(resultado);
        
    return resultado;
  }
  
  /**
   * Obter dados de uma encomenda.
   * @param id id da encomenda.
   * @return detalhes da encomenda.
   */
  public Encomenda getEncomendaById(Integer id) {
    Optional<Encomenda> enc = encomendaRepo.findById(id);
    
    if (!enc.isPresent()) {
      throw new NoSuchElementException();
    }
    return enc.get();
  }
  
  /**
   * Atualiza estado da encomenda.
   */
  public void updateEstado(Encomenda enc) {
    EstadoEncomenda now = enc.getEstados().get(enc.getEstados().size() - 1).getEstadoEncomenda();

    Set<EstadoEncomenda> estadosParcelas = new HashSet<>();
    List<EncomendaRestaurante> parcelas = enc.getParcelas();
    
    parcelas.forEach(par -> estadosParcelas.add(par.getEstado()));
    if (estadosParcelas.size() == 1 && !estadosParcelas.contains(now)) {
      EstadoEncomendaHora novoEstado = new EstadoEncomendaHora(enc,
          estadosParcelas.iterator().next(), LocalDate.now(), LocalTime.now());
      estadoEncomendaHoraRepo.saveAll(Arrays.asList(novoEstado));
      enc.getEstados().add(novoEstado);
    }
  }
}
