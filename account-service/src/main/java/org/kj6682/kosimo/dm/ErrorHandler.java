package org.kj6682.kosimo.dm;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luigi on 23.04.16.
 */
@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    void unsupportedOperation(HttpServletResponse response) throws IOException {
        response.sendError(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                "This feature is currently unavailable"
        );
    }

    @ExceptionHandler(AccountNotFoundException.class)
    void accountNotFound(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    void handleGenericException( HttpServletResponse response, Exception e) throws IOException {
        String msg = "There was an error processing your request: " + e.getMessage();
        response.sendError(
                HttpStatus.BAD_REQUEST.value(),
                msg
        );
    }
}
