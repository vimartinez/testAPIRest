package ar.com.vic.test.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8957008171827792510L;
	
	public MovieNotFoundException (String message) {
		super("No se enconraron películas con el texto:" + message);
	}

}
