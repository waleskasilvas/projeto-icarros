package com.api.icarros.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StandardError {

    private LocalDateTime localDateTime;
    private Integer status;
    private String message;
    private String path;

}
