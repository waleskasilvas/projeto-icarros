package com.api.icarros.service;

import com.api.icarros.domain.*;
import com.api.icarros.domain.exceptions.InternalErrorException;

import com.api.icarros.domain.exceptions.ObjectException;
import com.api.icarros.repository.FipeRepository;

import feign.FeignException;
import feign.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class FipeServiceTest {

    @InjectMocks
    FipeService service;

    @Mock
    FeignException exception;

    @Mock
    ObjectException objectException;

    @Mock
    FipeRepository repository;

    @Mock
    Marca marca;

    @Mock
    Veiculo veiculo;

    @Mock
    Ano ano;

    @Mock
    ModeloAno modeloAno;

    @BeforeEach
    public void setUp() {
        marca = new Marca(2, "tesla");
        modeloAno = new ModeloAno(List.of(new Modelo(1, "Tesla 2")), List.of( new Ano ("1", "Vinte")));
        ano = new Ano("1", "2003");
        veiculo = Veiculo.builder()
                .tipoVeiculo(1)
                .valor("R$ 40.558,00")
                .marca("Tesla")
                .modelo("Hibrido")
                .anoModelo(2021)
                .combustivel("gasolina")
                .codigoFipe("1234")
                .mesReferencia("Agosto de 2023")
                .siglaCombustivel("G")
                .build();

    }

    @Test
    void listarMarcasSucesso() {
        when(repository.listarMarcas())
                .thenReturn(ResponseEntity.of(Optional.of(List.of(marca))));
        List<Marca> response = service.listarMarcas();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Marca.class, response.get(0).getClass());
    }

    @Test
    void listarMarcasErroInternalErrorException() {
        when(repository.listarMarcas())
                .thenThrow(new RuntimeException());
        try {
            service.listarMarcas();
        }
        catch (RuntimeException e) {
            assertEquals(InternalErrorException.class, e.getClass());
        }
    }

//    @Test
//    void listarMarcasErroObjectException() {
//        FeignException feignException = FeignException.errorStatus("FeignException message",
//                Response.builder().status(400).reason("Bad Request").build());
//        when(repository.listarMarcas())
//                .thenThrow(new ObjectException(feignException));
//        try {
//            service.listarMarcas();
//        }
//        catch (FeignException e) {
//            assertEquals(ObjectException.class, e.getClass());
//        }
//    }

    @Test
    void listarModelosPorMarcaSucesso() {
        when(repository.listarModelosPorMarca(any()))
                .thenReturn(ResponseEntity.of(Optional.of(modeloAno)));
        ModeloAno response = service.listarModelosPorMarca(1);
        assertNotNull(response);
        assertEquals(ModeloAno.class, response.getClass());
    }

    @Test
    void listarModelosPorMarcaInternalErroException() {
        when(repository.listarModelosPorMarca(any()))
                .thenThrow(new RuntimeException());
        try {
            service.listarModelosPorMarca(1);
        }
        catch (RuntimeException e) {
            assertEquals(InternalErrorException.class, e.getClass());
        }
    }

    @Test
    void listarAnosPorModeloSucesso() {
        when(repository.listarAnosPorModelo(any(), any()))
                .thenReturn(ResponseEntity.of(Optional.of(List.of(ano))));
        List<Ano> response = service.listarAnosPorModelo(1, "Tesla");
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Ano.class, response.get(0).getClass());
    }

    @Test
    void listarAnosPorModeloInternalErroException() {
        when(repository.listarAnosPorModelo(any(), any()))
                .thenThrow(new RuntimeException());
        try {
            service.listarAnosPorModelo(1, "Tesla");
        }
        catch (RuntimeException e) {
            assertEquals(InternalErrorException.class, e.getClass());
        }
    }

    @Test
    void consultarVeiculoSucesso() {
        when(repository.consultarVeiculo(any(), any(), any()))
                .thenReturn(ResponseEntity.of(Optional.of(veiculo)));
        Veiculo response = service.consultarVeiculo(1, "Tesla", "2018");
        assertNotNull(response);
        assertEquals(Veiculo.class, response.getClass());
    }

    @Test
    void consultarVeiculoInternalErroException() {
        when(repository.consultarVeiculo(any(), any(), any()))
                .thenThrow(new RuntimeException());
        try {
            service.consultarVeiculo(1, "Tesla", "2018");
        }
        catch (RuntimeException e) {
            assertEquals(InternalErrorException.class, e.getClass());
        }
    }
}
