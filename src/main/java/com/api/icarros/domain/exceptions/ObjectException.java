package com.api.icarros.domain.exceptions;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectException extends FeignException {

    public ObjectException(FeignException exception) {
        super(exception.status(), convertMessage(exception));
    }
    private static String convertMessage(FeignException exception){
        log.info("mensagem {}", exception.toString());
        var msg = exception.toString();
        String status = exception.status() + "";
        String i = msg.substring(msg.indexOf(status),msg.indexOf("to"));
        return i.replace("]", "").replace("[", "");
    }
}
