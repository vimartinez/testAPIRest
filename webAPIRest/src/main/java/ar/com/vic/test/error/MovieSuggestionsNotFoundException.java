package ar.com.vic.test.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieSuggestionsNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8729318462103720148L;

	public MovieSuggestionsNotFoundException (String message) {
		super("No se enconraron películas sugeridas para la pelicula:" + message);
	}

}