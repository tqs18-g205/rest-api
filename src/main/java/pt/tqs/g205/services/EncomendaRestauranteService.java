package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.EncomendaRestaurante;
import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.domain.PratosPorEncomenda;
import pt.tqs.g205.dto.EncomendaRestauranteDto;
import pt.tqs.g205.repositories.EncomendaRepository;
import pt.tqs.g205.repositories.EncomendaRestauranteRepository;
import pt.tqs.g205.repositories.EstadoEncomendaRepository;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class EncomendaRestauranteService {
  @Autowired
  private EstadoEncomendaRepository estadoEncomendaRepo;
  
  @Autowired
  private PratoRepository pratoRepo;
  
  @Autowired
  private EncomendaRepository encomendaRepo;
  
  @Autowired
  private EncomendaRestauranteRepository encomendaRestauranteRepo;
  
  /**
   * Separar a encomenda em parcelas, com os produtos para cada restaurante respetivo.
   * @param enc encomenda.
   * @return lista de parcelas.
   */
  public List<EncomendaRestaurante> criarParcelas(Encomenda enc) {
    List<EncomendaRestaurante> parcelas = new ArrayList<>();
    
    Optional<EstadoEncomenda> optEstado = estadoEncomendaRepo.findById(1);
    
    if (!optEstado.isPresent()) {
      throw new NoSuchElementException();
    }
    
    EstadoEncomenda estado = optEstado.get();
    
    Set<Integer> restaurantes = new HashSet<>();
    
    for (PratosPorEncomenda ppe : enc.getPratos()) {
      Optional<Prato> optPrato = pratoRepo.findById(ppe.getId().getPratoId());
      
      if (!optPrato.isPresent()) {
        throw new NoSuchElementException();
      }
      
      Prato prato = optPrato.get();
      restaurantes.add(prato.getRestaurante().getId());
    }
    
    restaurantes.forEach(res -> { 
      EncomendaRestaurante parcela = new EncomendaRestaurante(null, res, enc, estado);
      parcelas.add(parcela);
      enc.getParcelas().add(parcela);
      estado.getParcelas().add(parcela);
    });
    
    encomendaRestauranteRepo.saveAll(parcelas);
    estadoEncomendaRepo.saveAll(Arrays.asList(estado));
    encomendaRepo.saveAll(Arrays.asList(enc));
    return parcelas;
  }
  
  /**
   * Obter todos os pratos de uma parcela.
   * @param parcela parcela.
   * @return lista de pratos.
   */
  private List<Prato> getPratosParcela(EncomendaRestaurante parcela) {
    List<Prato> pratos = new ArrayList<>();
    Encomenda enc = parcela.getEncomenda();
    
    enc.getPratos().forEach(ppe -> {
      Prato prato = pratoRepo.findById(ppe.getId().getPratoId()).get();
      if (prato.getRestaurante().getId().equals(parcela.getRestaurante())) {
        prato.setEncomendas(null);
        prato.setIngredientes(null);
        prato.setCategorias(null);
        
        pratos.add(prato);
      }
    });
    return pratos;
  }
  
  /**
   * Obter uma encomenda do restaurante.
   * @param id id da parcela.
   * @return detalhes da parcela.
   */
  public EncomendaRestaurante getParcela(Integer id) {
    Optional<EncomendaRestaurante> optParcela = encomendaRestauranteRepo.findById(id);
    
    if (!optParcela.isPresent()) {
      throw new NoSuchElementException();
    }
    
    EncomendaRestaurante parcela = optParcela.get();
    
    parcela.setPratos(getPratosParcela(parcela));
    
    parcela.getEncomenda().setPratos(null);
    parcela.getEncomenda().setEstados(null);
    parcela.getEncomenda().setId(null);
    
    return parcela;
  }
  
  /**
   * Obter todas as encomendas de um restaurante.
   * @param restaurante id do restaurante.
   * @return lista de encomendas do restaurante.
   */
  public List<EncomendaRestauranteDto> getEncomendas(Integer restaurante) {
    List<EncomendaRestaurante> parcelas = encomendaRestauranteRepo.findByRestaurante(restaurante);
    List<EncomendaRestauranteDto> res = new ArrayList<>();
    
    
    parcelas.forEach(par -> {
      EncomendaRestauranteDto dto = new EncomendaRestauranteDto(par.getId(), par.getEncomenda().getTipoEntrega(), 
          par.getEstado());
      res.add(dto);
    });
    
    return res;
  }


}
