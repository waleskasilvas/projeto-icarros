package com.api.icarros.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("modelos")
    List<Modelo> modelos;
    @JsonProperty("anos")
    List<Ano> anos;
}
