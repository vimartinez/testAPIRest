package ar.com.vic.test.webAPIRest.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ar.com.vic.test.error.MovieException;
import ar.com.vic.test.error.MovieNotFoundException;
import ar.com.vic.test.error.MovieSuggestionsNotFoundException;
import ar.com.vic.test.webAPIRest.model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MovieService {

	private final String urlListMoviesYTS = "https://yts.mx/api/v2/list_movies.json?query_term=";
	private final String urlListMovieSugestionsYTS = "https://yts.mx/api/v2/movie_suggestions.json?movie_id=";
	
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray; 
	ArrayList<Movie> moviesList = new ArrayList<Movie>();
	
	public Iterable<Movie> getMovieByName(String movieName) throws IOException {
		
		jsonObject = getMoviesFromYTS(urlListMoviesYTS,movieName);
		moviesList.clear(); 
		if (jsonObject.getInt("movie_count") > 0) {
			jsonArray = jsonObject.getJSONArray("movies");
			for(int i=0;i<jsonArray.length();i++){
				try {
					Movie movie = new Movie();
					movie.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("id").toString()));
					movie.setTitle(jsonArray.getJSONObject(i).get("title").toString());
					movie.setImdb_code(jsonArray.getJSONObject(i).get("imdb_code").toString());
					movie.setSlug(jsonArray.getJSONObject(i).get("slug").toString());
					movie.setYear(jsonArray.getJSONObject(i).get("year").toString());
					movie.setRating(Float.parseFloat(jsonArray.getJSONObject(i).get("rating").toString()));
					movie.setRuntime(Integer.parseInt(jsonArray.getJSONObject(i).get("runtime").toString()));
					movie.setMedium_cover_image(jsonArray.getJSONObject(i).get("medium_cover_image").toString());
					movie.setSynopsis(jsonArray.getJSONObject(i).get("synopsis").toString());
					movie.setGenres(jsonArray.getJSONObject(i).getJSONArray("genres"));
					moviesList.add(movie);
				}
				catch (JSONException e) {
					e.printStackTrace();
					throw new MovieException(e.getMessage());
				}
			}
		}
		else {
			throw new MovieNotFoundException(movieName);
		}
		
		return moviesList;
	}

	public Iterable<Movie> getMovieSuggestions(Integer movieId) throws IOException  {
		jsonObject = getMoviesFromYTS(urlListMovieSugestionsYTS,movieId.toString());
		moviesList.clear(); 
		if (jsonObject.getInt("movie_count") > 0) {
			jsonArray = jsonObject.getJSONArray("movies");
			for(int i=0;i<jsonArray.length();i++){
				try {
					Movie movie = new Movie();
					movie.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("id").toString()));
					movie.setTitle(jsonArray.getJSONObject(i).get("title").toString());
					movie.setImdb_code(jsonArray.getJSONObject(i).get("imdb_code").toString());
					movie.setSlug(jsonArray.getJSONObject(i).get("slug").toString());
					movie.setYear(jsonArray.getJSONObject(i).get("year").toString());
					movie.setRating(Float.parseFloat(jsonArray.getJSONObject(i).get("rating").toString()));
					movie.setRuntime(Integer.parseInt(jsonArray.getJSONObject(i).get("runtime").toString()));
					movie.setMedium_cover_image(jsonArray.getJSONObject(i).get("medium_cover_image").toString());
					movie.setSynopsis(jsonArray.getJSONObject(i).get("synopsis").toString());
					movie.setGenres(jsonArray.getJSONObject(i).getJSONArray("genres"));
					moviesList.add(movie);
				}
				catch (JSONException e) {
					e.printStackTrace();
					throw new MovieException(e.getMessage());
				}
			}
		}
		else {
			throw new MovieSuggestionsNotFoundException(movieId.toString());
		}
		
		return moviesList;
	}
	
	private JSONObject getMoviesFromYTS(String urlService,String data) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(urlService + data)
				.build();
		
		Call call = client.newCall(request);
		Response response;
		JSONObject jsonObject;
		try {
			response = call.execute();
			jsonObject =  new JSONObject(response.body().string());
			if (jsonObject.get("status").equals("ok")) {
				jsonObject = (JSONObject) jsonObject.get("data");
			}
			else {
				throw new MovieException("El servicio no respondió correctamente:"+jsonObject.getString("status_message"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new MovieException("No se pudo ejecutar el servicio:" + e.getMessage());
			
		}
		
		return jsonObject;
		
	}

}
