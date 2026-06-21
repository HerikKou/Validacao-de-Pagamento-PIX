package Service.DTO;

import java.math.BigDecimal;

import Service.Model.StatusPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PagamentoResponse {
    private Long id;
    private Long userId; 
     private String recebedorEsperado;
    private BigDecimal valor;
    private String chavePix;
    private String tipoRecebedor;
    private String documentoRecebedor;   
    private String nomeRecebedor;
     private StatusPagamento status;
     private String descricao;
      public PagamentoResponse(){}
     public PagamentoResponse(Long id, Long userId, String recebedorEsperado, BigDecimal valor, String chavePix,
            String tipoRecebedor, String documentoRecebedor, String nomeRecebedor, StatusPagamento status, String descricao) {
        this.id = id;
        this.userId = userId;
        this.recebedorEsperado = recebedorEsperado;
        this.valor = valor;
        this.chavePix = chavePix;
        this.tipoRecebedor = tipoRecebedor;
        this.documentoRecebedor = documentoRecebedor;
        this.nomeRecebedor = nomeRecebedor;
        this.status = status;
        this.descricao = descricao;
     }
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public Long getUserId() {
         return userId;
     }
     public void setUserId(Long userId) {
         this.userId = userId;
     }
     public String getRecebedorEsperado() {
         return recebedorEsperado;
     }
     public void setRecebedorEsperado(String recebedorEsperado) {
         this.recebedorEsperado = recebedorEsperado;
     }
     public BigDecimal getValor() {
         return valor;
     }
     public void setValor(BigDecimal valor) {
         this.valor = valor;
     }
     public String getChavePix() {
         return chavePix;
     }
     public void setChavePix(String chavePix) {
         this.chavePix = chavePix;
     }
     public String getTipoRecebedor() {
         return tipoRecebedor;
     }
     public void setTipoRecebedor(String tipoRecebedor) {
         this.tipoRecebedor = tipoRecebedor;
     }
     public String getDocumentoRecebedor() {
         return documentoRecebedor;
     }
     public void setDocumentoRecebedor(String documentoRecebedor) {
         this.documentoRecebedor = documentoRecebedor;
     }
     public String getNomeRecebedor() {
         return nomeRecebedor;
     }
     public void setNomeRecebedor(String nomeRecebedor) {
         this.nomeRecebedor = nomeRecebedor;
     }
     public StatusPagamento getStatus() {
         return status;
     }
     public void setStatus(StatusPagamento status) {
         this.status = status;
     }
     public String getDescricao() {
         return descricao;
     }
     public void setDescricao(String descricao) {
         this.descricao = descricao;
     }
     
}
