package Validador.de.Destinatario.Pix.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Service.DTO.PagamentoRequest;
import Service.DTO.PagamentoResponse;
import Service.Model.Pagamento;
import Service.Model.StatusPagamento;
import Service.Repository.PagamentoRepository;
import Service.Service.TransformarResponse;
import Service.Service.ValidarService;

@ExtendWith(MockitoExtension.class)
public class ValidarServiceTest {

    @Mock
    private PagamentoRepository repository;

    @Mock
    private TransformarResponse responseConverter;

    @InjectMocks
    private ValidarService validarService;

    private PagamentoRequest request;
    private Pagamento chavePixCadastrada;
    private PagamentoResponse responseEsperado;

    @BeforeEach
    void setUp() {
        request = new PagamentoRequest();
        request.setUserId(1L);
        request.setChavePix("128956");
        request.setValor(new BigDecimal("150.00"));
        request.setRecebedorEsperado("Maria");

        chavePixCadastrada = new Pagamento();
        chavePixCadastrada.setChavePix("128956");
        chavePixCadastrada.setNomeRecebedor("Maria");

        responseEsperado = new PagamentoResponse();
        responseEsperado.setUserId(1L);
        responseEsperado.setChavePix("128956");
        responseEsperado.setValor(new BigDecimal("150.00"));
        responseEsperado.setRecebedorEsperado("Maria");
        responseEsperado.setNomeRecebedor("Maria");
    }

    @Test
    void deveValidarPagamentoComSucessoQuandoRecebedorForIgual() {
        responseEsperado.setStatus(StatusPagamento.APROVADO);
        responseEsperado.setDescricao("Destinatário validado com sucesso");

        when(repository.findByChavePix(request.getChavePix())).thenReturn(chavePixCadastrada);
        when(repository.save(any(Pagamento.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(responseConverter.ResponsePagamento(any(Pagamento.class))).thenReturn(responseEsperado);

        PagamentoResponse resultado = validarService.ValidarPagamento(request);

        assertNotNull(resultado);
        assertEquals(StatusPagamento.APROVADO, resultado.getStatus());
        assertEquals("Destinatário validado com sucesso", resultado.getDescricao());
        verify(repository).findByChavePix(request.getChavePix());
        verify(repository).save(any(Pagamento.class));
    }

    @Test
    void deveGerarAlertaQuandoRecebedorEsperadoForDiferente() {
        request.setRecebedorEsperado("João");
        responseEsperado.setRecebedorEsperado("João");
        responseEsperado.setStatus(StatusPagamento.ALERTA);
        responseEsperado.setDescricao("A chave Pix pertence a um recebedor diferentente do esperado");

        when(repository.findByChavePix(request.getChavePix())).thenReturn(chavePixCadastrada);
        when(repository.save(any(Pagamento.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(responseConverter.ResponsePagamento(any(Pagamento.class))).thenReturn(responseEsperado);

        PagamentoResponse resultado = validarService.ValidarPagamento(request);

        assertNotNull(resultado);
        assertEquals(StatusPagamento.ALERTA, resultado.getStatus());
        assertEquals("A chave Pix pertence a um recebedor diferentente do esperado", resultado.getDescricao());
    }

    @Test
    void deveGerarAlertaQuandoRecebedorEsperadoForNulo() {
        request.setRecebedorEsperado(null);
        responseEsperado.setRecebedorEsperado(null);
        responseEsperado.setStatus(StatusPagamento.ALERTA);
        responseEsperado.setDescricao("A chave Pix pertence a um recebedor diferentente do esperado");

        when(repository.findByChavePix(request.getChavePix())).thenReturn(chavePixCadastrada);
        when(repository.save(any(Pagamento.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(responseConverter.ResponsePagamento(any(Pagamento.class))).thenReturn(responseEsperado);

        PagamentoResponse resultado = validarService.ValidarPagamento(request);

        assertNotNull(resultado);
        assertEquals(StatusPagamento.ALERTA, resultado.getStatus());
    }
}