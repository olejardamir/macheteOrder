package com.developer.machete;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.developer.machete.helpers.Scraper;
import com.developer.machete.helpers.StringDecodeHelper;
import com.developer.machete.model.FavouriteFilm;
import com.developer.machete.model.UserQuery;
import com.developer.machete.services.FilmsServices;
import com.google.gson.Gson;

@Controller
@SpringBootApplication
public class MacheteApplication {

	@Autowired
	private FilmsServices filmsServices;

	private StringDecodeHelper stringDecodeHelper = new StringDecodeHelper();

 
	@PostConstruct
	private void checkUpdate() {
	boolean needsUpdate = filmsServices.needsUpdate();
		if(needsUpdate) {
			filmsServices.insertFilmDB(new Scraper().scrapeAPIs());		
		}
	}
	
	
	
	@GetMapping(value = "/getFilmOrder")
	@ResponseBody
	public String filmOrder() {
		return filmsServices.getFilmOrder();
	}

	@GetMapping(value = "/getMacheteOrder")
	@ResponseBody
	public String macheteOrder() {
		return filmsServices.getMacheteOrder();
	}
	

	@PostMapping("/recordUser")
	@ResponseBody
	public void createCourse(@RequestBody String data) {
		data = stringDecodeHelper.decode(data);
		UserQuery queryData = new Gson().fromJson(data, UserQuery.class);		
		filmsServices.insertQueryData(queryData);
	}
	
	@PostMapping("/saveFilm")
	@ResponseBody
	public void saveFilm(@RequestBody String data) {
		data = stringDecodeHelper.decode(data);
		FavouriteFilm favouriteFilm = new Gson().fromJson(data, FavouriteFilm.class);
		UserQuery queryData = new UserQuery();
		queryData.setUsrquery("Add "+favouriteFilm.getImdb_id()+" to favourites");
		queryData.setIp(favouriteFilm.getIp());
		filmsServices.addFavouriteFilm(favouriteFilm, queryData);
	}
	
	
 
	

	public static void main(String[] args) {
		SpringApplication.run(MacheteApplication.class, args);
	}

}