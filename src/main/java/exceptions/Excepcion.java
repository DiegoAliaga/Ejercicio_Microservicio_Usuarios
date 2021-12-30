package exceptions;

import lombok.Getter;


public class Excepcion extends RuntimeException{
	@Getter
	private String mensaje;
	public Excepcion(String message) {
		super(message);
		this.mensaje=message;
	}
	
	
}
