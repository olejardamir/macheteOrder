package com.developer.machete.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.developer.machete.model.Films;
import com.developer.machete.model.MovieData;
import com.developer.machete.model.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Scraper {

	private static final String ORDERURI = "https://mysterious-peak-27876.herokuapp.com/";
	private static final String OMDURIPREFIX="http://www.omdbapi.com/?i=";
	private static final String OMDURISUFFIX="&apikey=57ec2f6d";
	private Gson gson;
	private RestTemplate restTemplate;
	
	public Scraper() {
		 gson = new Gson();
		 restTemplate = new RestTemplate();
	}

	public List<Films> scrapeAPIs(){
	    List<Order> parsedOrder = scrapeHeroku();
	    ArrayList<Films> queries = new ArrayList<>();
	    getMovieData(parsedOrder, queries); 
		return queries;
	}

	private List<Order> scrapeHeroku() {
		String result = restTemplate.getForObject(ORDERURI, String.class);
		return  gson.fromJson(result, new TypeToken<List<Order>>(){}.getType());
	}

	private void getMovieData(List<Order> parsedOrder, ArrayList<Films> queries) {
		parsedOrder.forEach(order->{
	    	Films tmpFilm = new Films();
	    	MovieData movieData = scrapeOmd(order);
	    	setFilmVariables(order, tmpFilm, movieData);
	    	queries.add(tmpFilm);
		});
	}

	private void setFilmVariables(Order order, Films tmpFilm, MovieData movieData) {
		tmpFilm.setImdb_id(order.getImdbId());
		tmpFilm.setMachete_id(order.getPosition().getMachete());
		tmpFilm.setRelease_id(order.getPosition().getRelease());
		tmpFilm.setActors(movieData.getActors());
		tmpFilm.setTitle(movieData.getTitle());
	}

	private MovieData scrapeOmd(Order order) {
		String uri = OMDURIPREFIX+order.getImdbId()+OMDURISUFFIX;
		String data = restTemplate.getForObject(uri, String.class);
		return gson.fromJson(data, MovieData.class);
	}
}
