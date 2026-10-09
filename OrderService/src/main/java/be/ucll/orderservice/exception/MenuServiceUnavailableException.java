package be.ucll.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class MenuServiceUnavailableException extends RuntimeException {
    public MenuServiceUnavailableException(String message) {
        super(message);
    }

    public MenuServiceUnavailableException(String message,Throwable exception) {
        super(message,exception);
    }

}
