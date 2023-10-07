package com.api.icarros.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo implements Serializable {

    @JsonProperty("TipoVeiculo")
    private Integer tipoVeiculo;
    @JsonProperty("Valor")
    private String valor;
    @JsonProperty("Marca")
    private String marca;
    @JsonProperty("Modelo")
    private String modelo;
    @JsonProperty("AnoModelo")
    private Integer anoModelo;
    @JsonProperty("Combustivel")
    private String combustivel;
    @JsonProperty("CodigoFipe")
    private String codigoFipe;
    @JsonProperty("MesReferencia")
    private String mesReferencia;
    @JsonProperty("SiglaCombustivel")
    private String siglaCombustivel;

}
