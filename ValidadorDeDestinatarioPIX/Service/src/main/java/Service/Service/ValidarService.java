package Service.Service;

import org.springframework.stereotype.Component;

import Service.DTO.PagamentoRequest;
import Service.DTO.PagamentoResponse;
import Service.Model.Pagamento;
import Service.Model.StatusPagamento;
import Service.Repository.PagamentoRepository;

@Component
public class ValidarService {

private final PagamentoRepository repository;
private final TransformarResponse response;



public ValidarService(PagamentoRepository repository, TransformarResponse response) {
    this.repository = repository;
    this.response = response;
}


public PagamentoResponse ValidarPagamento(PagamentoRequest request){
    Pagamento chavePix = repository.findByChavePix(request.getChavePix());
    StatusPagamento statusPagamento = verficarRecebedor(chavePix.getNomeRecebedor(), chavePix.getRecebedorEsperado());
    String descricao = DefinirDescricao(statusPagamento);
    Pagamento pagamento = new Pagamento();
    pagamento.setUserId(request.getUserId());
    pagamento.setRecebedorEsperado(request.getRecebedorEsperado());
    pagamento.setValor(request.getValor());
    pagamento.setChavePix(request.getChavePix());
    pagamento.setStatus(statusPagamento);
    pagamento.setDescricao(descricao);
    Pagamento salvar = repository.save(pagamento);

    return response.ResponsePagamento(pagamento);

}


private StatusPagamento verficarRecebedor(String nomeRecebedor, String recebedorEsperado){
 if(recebedorEsperado ==null || !recebedorEsperado.equals(nomeRecebedor)){
    return StatusPagamento.ALERTA;
 }
    
 return StatusPagamento.APROVADO;

}


private String DefinirDescricao(StatusPagamento statusPagamento){
    if(statusPagamento == StatusPagamento.ALERTA){
        return "A chave Pix pertence a um recebedor diferentente do esperado";
    }
    else if(statusPagamento == StatusPagamento.REJEITADO){
        return "Chave Pix não encontrada";
    }
    return"Destinatário validado com sucesso";
}




}
