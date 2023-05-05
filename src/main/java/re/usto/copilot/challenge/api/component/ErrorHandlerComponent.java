package re.usto.copilot.challenge.api.component;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import re.usto.copilot.challenge.api.component.model.StandardError;
import re.usto.copilot.challenge.api.component.model.ValidationError;

@ControllerAdvice
public class ErrorHandlerComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerComponent.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        LOGGER.error(e.getMessage());
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation Error",
                System.currentTimeMillis());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
