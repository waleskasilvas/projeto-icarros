package com.api.icarros.service;

import com.api.icarros.domain.*;
import com.api.icarros.repository.FipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FipeService {

    @Autowired
    private FipeRepository repository;

    public List<Marca> listarMarcas() {
        return repository.listarMarcas().getBody();
    }

    public List<ModeloAno> listarModelosPorMarca(Integer id) {
        return repository.listarModelosPorMarca(id).getBody();
    }

    public List<Ano> listarAnosPorModelo(Integer id, String modelo) {
        return repository.listarAnosPorModelo(id, modelo).getBody();
    }

    public Veiculo consultarVeiculo(Integer id, String modelo, String anoFabricacao){
        return repository.consultarVeiculo(id, modelo, anoFabricacao).getBody();
    }

}
