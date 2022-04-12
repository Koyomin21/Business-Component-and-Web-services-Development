package kz.iitu.itse1909.borangaziyev.exceptions;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = {RestController.class})
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex) {
        ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "What else do you want to add");
        System.out.println("Error Message !!!");
        return new ResponseEntity<ErrorMessage>(exceptionResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST);
    };

}

@Data
class ErrorMessage {
    private String message;
    private String details;

    public ErrorMessage(){};
    public ErrorMessage(String message, String details) {
        this.message = message;
        this.details = details;
    }

}