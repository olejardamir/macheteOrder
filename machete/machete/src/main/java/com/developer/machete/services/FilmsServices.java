package com.developer.machete.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.developer.machete.mapper.FilmsMapper;
import com.developer.machete.model.FavouriteFilm;
import com.developer.machete.model.Films;
import com.developer.machete.model.UserQuery;
import com.google.gson.Gson;

@Configuration
public class FilmsServices {

	@Autowired
	private FilmsMapper filmsMapper;
	
	private Gson gson = new Gson();
	
	@Bean
	public String getFilmOrder() {
		List<Films> films = filmsMapper.getFilmOrder();
		return gson.toJson(films);
	}
	
	@Bean
	public String getMacheteOrder() {
		List<Films> films = filmsMapper.getMacheteOrder();
		return gson.toJson(films);
	}
	
 	public Boolean insertQueryData(UserQuery usrquery) { 
		filmsMapper.insertQueryData(usrquery);
		return true;
	}

	public Boolean addFavouriteFilm(FavouriteFilm favouriteFilm, UserQuery query) {
		filmsMapper.insertFavouriteFilm(favouriteFilm);
		filmsMapper.insertQueryData(query);
		return true;
	}
	
	@Bean
	public boolean needsUpdate() {
		String tblsz = filmsMapper.getFilmsElement();
		return (tblsz==null);
	}

	public Boolean insertFilmDB(List<Films> scrapeAPIs) {
		scrapeAPIs.forEach(film -> {filmsMapper.insertFilm(film);});
		return true;
	}
}
