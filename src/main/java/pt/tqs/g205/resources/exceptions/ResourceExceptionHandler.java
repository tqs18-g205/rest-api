package pt.tqs.g205.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pt.tqs.g205.services.exceptions.AuthorizationException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(AuthorizationException.class)
  public ResponseEntity<StandardError> authorization(AuthorizationException e,
      HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
        "Access Denied", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
  }
}
