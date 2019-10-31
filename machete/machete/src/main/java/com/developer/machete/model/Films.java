package com.developer.machete.model;

public class Films {
	private long id;
	private Integer machete_id;
	private long release_id;
	private Integer title_number;
	private String imdb_id;
	private String title;
	private String actors;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getMachete_id() {
		return machete_id;
	}
	public void setMachete_id(Integer machete_id) {
		this.machete_id = machete_id;
	}
	public Integer getTitle_number() {
		return title_number;
	}
	public void setTitle_number(Integer title_number) {
		this.title_number = title_number;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getRelease_id() {
		return release_id;
	}
	public void setRelease_id(long release_id) {
		this.release_id = release_id;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
}
