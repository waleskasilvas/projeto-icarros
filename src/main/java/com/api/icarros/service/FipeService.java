package com.api.icarros.service;

import com.api.icarros.domain.*;
import com.api.icarros.domain.exceptions.InternalErrorException;
import com.api.icarros.domain.exceptions.ObjectException;
import com.api.icarros.repository.FipeRepository;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class FipeService {

    @Autowired
    private FipeRepository repository;

    public List<Marca> listarMarcas() {

        try {
            return repository.listarMarcas().getBody();
        }
        catch (FeignException e) {
            log.info("Erro FeignClient {} ", e.getMessage());
            throw new ObjectException(e);
        }
        catch (RuntimeException e) {
            log.info("RuntimeException {} ", e.getMessage());
            throw new InternalErrorException(e.getMessage());
        }

    }

    public ModeloAno listarModelosPorMarca(Integer id) {
        log.info("ID {} ", id);
        try {
            return repository.listarModelosPorMarca(id).getBody();
        }
        catch (FeignException e) {
            log.info("Erro FeignClient {} ", e.getMessage());
            throw new ObjectException(e);
        }
        catch (RuntimeException e) {
            log.info("RuntimeException {} ", e.getMessage());
            throw new InternalErrorException(e.getMessage());
        }
    }

    public List<Ano> listarAnosPorModelo(Integer id, String modelo) {
        log.info("ID {} \n Modelo: {} ", id, modelo);
        try {
            return repository.listarAnosPorModelo(id, modelo).getBody();
        }
        catch (FeignException e) {
            log.info("Erro FeignClient {} ", e.getMessage());
            throw new ObjectException(e);
        }
        catch (RuntimeException e) {
            log.info("RuntimeException {} ", e.getMessage());
            throw new InternalErrorException(e.getMessage());
        }

    }

    public Veiculo consultarVeiculo(Integer id, String modelo, String anoFabricacao){
        log.info("ID {} \n Modelo: {} \n Ano de Fabricacao: {} ", id, modelo, anoFabricacao);
        try {
            return repository.consultarVeiculo(id, modelo, anoFabricacao).getBody();
        }
        catch (FeignException e) {
            log.info("Erro FeignClient {} ", e.getMessage());
            throw new ObjectException(e);
        }
        catch (RuntimeException e) {
            log.info("RuntimeException {} ", e.getMessage());
            throw new InternalErrorException(e.getMessage());
        }

    }

}
