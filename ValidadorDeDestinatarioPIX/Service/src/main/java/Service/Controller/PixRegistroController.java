package Service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.DTO.PixRegistryRequest;
import Service.DTO.PixRegistryResponse;
import Service.Service.PixResgistroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("registrar/")
@RestController
public class PixRegistroController {


private final PixResgistroService service;

public PixRegistroController(PixResgistroService service) {
    this.service = service;
}
@PostMapping("chavePix")
public ResponseEntity<PixRegistryResponse> registrarChavePix(@RequestBody PixRegistryRequest request){
    PixRegistryResponse response = service.registrarPix(request);
    return ResponseEntity.status(201).body(response);
}

}
