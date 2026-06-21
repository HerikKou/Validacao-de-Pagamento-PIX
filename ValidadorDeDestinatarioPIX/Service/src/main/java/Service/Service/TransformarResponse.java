package Service.Service;

import org.springframework.stereotype.Component;

import Service.DTO.PagamentoResponse;
import Service.DTO.PixRegistryResponse;
import Service.Model.Pagamento;
import Service.Model.StatusPagamento;
@Component
public class TransformarResponse {


public PixRegistryResponse transformarPixResponse(Pagamento pagamento){


    PixRegistryResponse response = new PixRegistryResponse();
    response.setNomeRecebedor(pagamento.getNomeRecebedor());
    response.setDocumentoRecebedor(pagamento.getDocumentoRecebedor());
    response.setTipoRecebedor(pagamento.getTipoRecebedor());
    response.setChavePix(pagamento.getChavePix());
    return response;
}


public PagamentoResponse ResponsePagamento(Pagamento pagamento){
    PagamentoResponse response = new PagamentoResponse();
    response.setId(pagamento.getId());
    response.setUserId(pagamento.getUserId());
    response.setRecebedorEsperado(pagamento.getRecebedorEsperado());
    response.setValor(pagamento.getValor());
    response.setChavePix(pagamento.getChavePix());
    response.setTipoRecebedor(pagamento.getTipoRecebedor());
    response.setDocumentoRecebedor(pagamento.getDocumentoRecebedor());
    response.setNomeRecebedor(pagamento.getNomeRecebedor());
    response.setStatus(pagamento.getStatus());
    response.setDescricao(pagamento.getDescricao());
    return response;
}



}
