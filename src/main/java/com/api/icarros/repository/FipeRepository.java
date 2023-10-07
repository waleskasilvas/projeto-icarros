package com.api.icarros.repository;

import com.api.icarros.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "api-fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeRepository {

    @GetMapping("/carros/marcas")
    ResponseEntity <List<Marca>> listarMarcas();

    @GetMapping("/carros/marcas/{id}/modelos")
    ResponseEntity <ModeloAno> listarModelosPorMarca(@PathVariable("id") Integer id);

    @GetMapping("/carros/marcas/{id}/modelos/{modelo}/anos")
    ResponseEntity <List<Ano>> listarAnosPorModelo(@PathVariable("id") Integer id,
                                                   @PathVariable("modelo") String modelo);

    @GetMapping("/carros/marcas/{id}/modelos/{modelo}/anos/{ano}")
    ResponseEntity <Veiculo> consultarVeiculo(@PathVariable("id") Integer id,
                                              @PathVariable("modelo") String modelo,
                                              @PathVariable("ano") String anoFabricacao);
}











