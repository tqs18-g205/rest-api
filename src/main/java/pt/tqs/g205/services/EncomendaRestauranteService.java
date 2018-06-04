package pt.tqs.g205.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.tqs.g205.domain.Encomenda;
import pt.tqs.g205.domain.EncomendaRestaurante;
import pt.tqs.g205.domain.EstadoEncomenda;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.domain.PratosPorEncomenda;
import pt.tqs.g205.repositories.EncomendaRepository;
import pt.tqs.g205.repositories.EncomendaRestauranteRepository;
import pt.tqs.g205.repositories.EstadoEncomendaRepository;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    
    EstadoEncomenda estado = estadoEncomendaRepo.findById(1).get();
    
    Set<Integer> restaurantes = new HashSet<>();
    
    for (PratosPorEncomenda ppe : enc.getPratos()) {
       Prato prato = pratoRepo.findById(ppe.getId().getPratoId()).get();
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

}
