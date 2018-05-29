package pt.tqs.g205.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pt.tqs.g205.services.exceptions.AuthorizationException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
  /**
   * Handler para exceção de autorização.
   * @param exc Exceção de autorização.
   * @param request Http Request.
   * @return resposta de erro.
   */
  @ExceptionHandler(AuthorizationException.class)
  public ResponseEntity<StandardError> authorization(AuthorizationException exc,
      HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
        "Access Denied", exc.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
  }
}
