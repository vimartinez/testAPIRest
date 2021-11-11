package ar.com.vic.test.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MovieException extends RuntimeException {

	private static final long serialVersionUID = 3941049509979366204L;

	public MovieException (String message) {
		
		super("Error: " + message);
		
	}
}
