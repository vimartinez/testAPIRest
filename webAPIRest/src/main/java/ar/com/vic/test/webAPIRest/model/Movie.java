package ar.com.vic.test.webAPIRest.model;

import org.json.JSONArray;

public class Movie {
	private Integer id;
	private String imdb_code;
	private String title;
	private String slug;
	private String year;
	private Float rating;
	private Integer runtime;
	private JSONArray genres;
	private String synopsis;
	private String medium_cover_image;
	
	public Movie(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Movie() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImdb_code() {
		return imdb_code;
	}

	public void setImdb_code(String imdb_code) {
		this.imdb_code = imdb_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public JSONArray getGenres() {
		return genres;
	}

	public void setGenres(JSONArray genres) {
		this.genres = genres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMedium_cover_image() {
		return medium_cover_image;
	}

	public void setMedium_cover_image(String medium_cover_image) {
		this.medium_cover_image = medium_cover_image;
	}
	
	

}
