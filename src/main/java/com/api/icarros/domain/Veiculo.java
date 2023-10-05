package com.api.icarros.domain;

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

    private String modelo;
    private String marca;
    private double preco;

}
