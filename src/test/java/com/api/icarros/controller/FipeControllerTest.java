package com.api.icarros.controller;

import com.api.icarros.domain.*;
import com.api.icarros.service.FipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FipeControllerTest {

    @InjectMocks
    FipeController controller;

    @Mock
    FipeService service;

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
    void findAllTest() {
        when(service.listarMarcas())
                .thenReturn((List.of(marca)));
        ResponseEntity<List<Marca>> response = controller.findAll();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Marca.class, response.getBody().get(0).getClass());
    }

    @Test
    void findByBrandTest() {
        when(service.listarModelosPorMarca(any()))
                .thenReturn(modeloAno);
        ResponseEntity<ModeloAno> response = controller.findByBrand(1);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ModeloAno.class, response.getBody().getClass());
    }

    @Test
    void findByModelTest() {
        when(service.listarAnosPorModelo(any(), anyString()))
                .thenReturn(List.of(ano));
        ResponseEntity <List<Ano>> response = controller.findByModel(1, "Tesla");
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Ano.class, response.getBody().get(0).getClass());
    }

    @Test
    void findByBrandYear() {
        when(service.consultarVeiculo(any(), anyString(), anyString()))
                .thenReturn(veiculo);
        ResponseEntity<Veiculo> response = controller.findByYear(1, "Tesla", "2018-1");
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Veiculo.class, response.getBody().getClass());
    }

}
