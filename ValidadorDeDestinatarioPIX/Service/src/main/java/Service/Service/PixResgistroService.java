package Service.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Service.DTO.PixRegistryRequest;
import Service.DTO.PixRegistryResponse;
import Service.Model.Pagamento;
import Service.Repository.PagamentoRepository;

@Service
public class PixResgistroService {

private final TransformarEntidade entidade ;
private final TransformarResponse response;
private final PagamentoRepository repository;
public PixResgistroService(TransformarEntidade entidade, TransformarResponse response, PagamentoRepository repository) {
    this.entidade = entidade;
    this.response = response;
    this.repository = repository;
}


public PixRegistryResponse registrarPix(PixRegistryRequest request){

Pagamento pagamento = entidade.TransformarEntidade(request);
Pagamento salvarPix = repository.save(pagamento);
PixRegistryResponse pix = response.transformarPixResponse(salvarPix);
return pix;
}





}
