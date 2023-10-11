package com.api.icarros.controller.exceptions;

import com.api.icarros.domain.StandardError;
import com.api.icarros.domain.exceptions.InternalErrorException;
import com.api.icarros.domain.exceptions.ObjectException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class FipeControllerExceptionTest {

    @InjectMocks
    FipeControllerException exception;

    @Mock
    ObjectException objectException;

    @Mock
    InternalErrorException internalErrorException;


    @Test
    void handleFeignTest() {
        ResponseEntity<StandardError> response = exception.feign(objectException, new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
    }

    @Test
    void handleInternalErrorTest() {
        ResponseEntity<StandardError> response = exception.internalError(internalErrorException, new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(StandardError.class, response.getBody().getClass());
    }
}
