package Service.DTO;

import java.math.BigDecimal;

public class PagamentoRequest {


private Long userId;
private BigDecimal valor;
private String recebedorEsperado;
private String chavePix;
public PagamentoRequest(){}
public PagamentoRequest(Long userId, BigDecimal valor, String recebedorEsperado, String chavePix) {
   
    this.userId = userId;
    this.valor = valor;
    this.recebedorEsperado = recebedorEsperado;
    this.chavePix = chavePix;
}


public BigDecimal getValor() {
    return valor;
}
public void setValor(BigDecimal valor) {
    this.valor = valor;
}
public String getRecebedorEsperado() {
    return recebedorEsperado;
}
public void setRecebedorEsperado(String recebedorEsperado) {
    this.recebedorEsperado = recebedorEsperado;
}
public String getChavePix() {
    return chavePix;
}
public void setChavePix(String chavePix) {
    this.chavePix = chavePix;
}


public Long getUserId() {
    return userId;
}


public void setUserId(Long userId) {
    this.userId = userId;
}











}
