package Service.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import Service.DTO.PagamentoRequest;
import Service.DTO.PixRegistryRequest;
import Service.Model.Pagamento;
import Service.Model.StatusPagamento;


@Component
public class TransformarEntidade {


    public Pagamento TransformarEntidade(PixRegistryRequest request){

        Pagamento pagamento = new Pagamento();
        pagamento.setNomeRecebedor(request.getNomeRecebedor());
        pagamento.setDocumentoRecebedor(request.getDocumentoRecebedor());
        pagamento.setTipoRecebedor(request.getTipoRecebedor());
        pagamento.setChavePix(request.getChavePix());
        pagamento.setValor(BigDecimal.ZERO);
        pagamento.setStatus(StatusPagamento.PENDENTE);
        return pagamento;

    }


    public Pagamento TransformarPagamentoEntidade(PagamentoRequest request){
        Pagamento pagamento = new Pagamento();
        pagamento.setUserId(request.getUserId());
        pagamento.setValor(request.getValor());
        pagamento.setChavePix(request.getChavePix());
        pagamento.setRecebedorEsperado(request.getRecebedorEsperado());
         pagamento.setStatus(StatusPagamento.PENDENTE);
        return pagamento;
    }
}
