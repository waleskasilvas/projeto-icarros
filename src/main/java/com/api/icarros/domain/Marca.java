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
public class Marca implements Serializable{

    @JsonProperty("codigo")
    private Integer codigo;
    @JsonProperty("nome")
    private String nome;

}
