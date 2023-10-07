package com.api.icarros.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo implements Serializable {

            private Integer tipoVeiculo;
            private double preco;
            private String marca;
            private String modelo;
            private Date anoModelo;
            private String combustivel;
            private String codigoFipe;
            private String mesReferencia;
            private char siglaCombustivel;

}
