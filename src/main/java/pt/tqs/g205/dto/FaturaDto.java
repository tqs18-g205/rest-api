package pt.tqs.g205.dto;

import java.io.Serializable;

/**
 * Fatura.
 */
public class FaturaDto implements Serializable {
  
  private static final long serialVersionUID = 1L;
  private String nome;
  private String nif;
  private Double montante;
  private Integer encomenda;
  
  public FaturaDto() {
    super();
  }

  /**
   * Construtor.
   * @param nome nome do cliente.
   * @param nif nif do cliente.
   * @param montante montante pago.
   * @param encomenda id da encomenda.
   */
  public FaturaDto(String nome, String nif, Double montante, Integer encomenda) {
    super();
    this.nome = nome;
    this.nif = nif;
    this.montante = montante;
    this.encomenda = encomenda;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public Double getMontante() {
    return montante;
  }

  public void setMontante(Double montante) {
    this.montante = montante;
  }

  public Integer getEncomenda() {
    return encomenda;
  }

  public void setEncomenda(Integer encomenda) {
    this.encomenda = encomenda;
  }
  
  
}
