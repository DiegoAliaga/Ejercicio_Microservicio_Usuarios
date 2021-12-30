package exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GestionExcepciones extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Excepcion.class)
	public ResponseEntity<String> manejarError(Excepcion e){
		return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@Order(Ordered.LOWEST_PRECEDENCE)
	public ResponseEntity<String> manejarError(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
