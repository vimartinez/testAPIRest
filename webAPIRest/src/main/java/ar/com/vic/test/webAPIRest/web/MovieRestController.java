package ar.com.vic.test.webAPIRest.web;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vic.test.util.ResponseObject;
import ar.com.vic.test.webAPIRest.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/movie")
public class MovieRestController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value = "/{str}", produces = "application/json")
	public @ResponseBody ResponseObject getMovieByName(@PathVariable("str") String movieName) {
		ResponseObject responseObject = new ResponseObject("ok","Consulta realizada",null);
		try {
			responseObject.setData(movieService.getMovieByName(movieName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@GetMapping(value = "", produces = "application/json")
	public @ResponseBody ResponseObject getMovieSuggestions(@RequestParam Integer id) {
		ResponseObject responseObject = new ResponseObject("ok","Consulta realizada",null);
		try {
			responseObject.setData(movieService.getMovieSuggestions(id));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseObject;
	}

}
