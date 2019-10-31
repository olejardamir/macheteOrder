package com.developer.machete.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.developer.machete.model.FavouriteFilm;
import com.developer.machete.model.Films;
import com.developer.machete.model.Query;

@Mapper
public interface FilmsMapper {

    @Select("select * from films order by release_id asc")
    List<Films> getFilmOrder();
    
    @Select("select * from films where machete_id is not null order by machete_id asc")
    List<Films> getMacheteOrder();
 
    
    @Insert("insert into queries(query,ip) values(#{query},#{ip})")
    void insertQueryData(Query query);
    
    @Insert("insert into favourites(imdb_id,ip) values(#{imdb_id},#{ip})")
	void insertFavouriteFilm(FavouriteFilm favouriteFilm);

    @Select("select * from films limit 1")
    String getFilmsElement();

    @Insert("insert into films(machete_id, release_id, title_number, imdb_id, title, actors) "
    		+ "values(#{machete_id}, #{release_id}, #{title_number}, #{imdb_id}, #{title}, #{actors})")
	void insertFilm(Films film);
    
	 

}
