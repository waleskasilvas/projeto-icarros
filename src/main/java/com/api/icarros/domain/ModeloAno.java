package com.api.icarros.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloAno implements Serializable {

    List<Modelo> modelos;
    List<Ano> anos;
}
