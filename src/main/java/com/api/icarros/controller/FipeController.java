package com.api.icarros.controller;

import com.api.icarros.domain.*;
import com.api.icarros.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RequestMapping
@RestController
public class FipeController {

    @Autowired
    FipeService service;
    @GetMapping("/marcas")
    public  ResponseEntity <List<Marca>> findAll() {
        return ResponseEntity.ok().body(service.listarMarcas());
    }

    @GetMapping("/marcas/{id}/modelos")
    public ResponseEntity <ModeloAno> findByBrand(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.listarModelosPorMarca(id));
    }

    @GetMapping("/marcas/{id}/modelos/{modelo}/anos")
    public ResponseEntity <List<Ano>> findByModel(@PathVariable("id") Integer id,
                                @PathVariable("modelo") String modelo) {
        return ResponseEntity.ok().body(service.listarAnosPorModelo(id, modelo));
    }
    @GetMapping("/marcas/{id}/modelos/{modelo}/anos/{ano}")
    public ResponseEntity <Veiculo> findByYear(@PathVariable("id") Integer id,
                                             @PathVariable("modelo") String modelo,
                                             @PathVariable("ano") String anoFabricacao) {
        return ResponseEntity.ok().body(service.consultarVeiculo(id, modelo, anoFabricacao));
    }

}

