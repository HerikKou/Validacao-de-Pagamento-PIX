package Service.Model;

import java.math.BigDecimal;

import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Pagamento {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
       
        private Long userId;
      
        private String recebedorEsperado;
       
        private BigDecimal valor;
       @NotNull
        private String chavePix;
        
        private String tipoRecebedor;
         
        private String documentoRecebedor;
         
        private String nomeRecebedor;
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "status")
       private StatusPagamento status;
       private String descricao;
        public Pagamento(){}
       public Pagamento(Long id, Long userId, String recebedorEsperado, BigDecimal valor, String chavePix,
            String tipoRecebedor, String documentoRecebedor, String nomeRecebedor, StatusPagamento status, String descric
            ) {
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
