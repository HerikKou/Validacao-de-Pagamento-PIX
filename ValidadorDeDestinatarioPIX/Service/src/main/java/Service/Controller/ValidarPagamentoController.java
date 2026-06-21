package Service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.DTO.PagamentoRequest;
import Service.DTO.PagamentoResponse;
import Service.Service.ValidarService;


@RequestMapping("realizarPagamento/")
@RestController
public class ValidarPagamentoController {


    private final ValidarService service;

    public ValidarPagamentoController(ValidarService service) {
        this.service = service;
    }
    @PostMapping("pagamento")
    public ResponseEntity<PagamentoResponse> validar(@RequestBody PagamentoRequest request){

        PagamentoResponse response = service.ValidarPagamento(request);
        return ResponseEntity.status(200).body(response);
    }
}
