package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable{

	private static final long serialVersionUID = 2562292635410148858L;

	@ApiModelProperty(position = 0)
	private Long id;
	@ApiModelProperty(position = 1)
	private String name;
	@ApiModelProperty(position = 2)
	private String surname;
	@ApiModelProperty(position = 3)
	private Date date_birth;
	@ApiModelProperty(position = 4)
	private List<TvShowRest> tvShows;
	@ApiModelProperty(position = 5)
	private List<ChapterRest> chapters;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getDate_birth() {
		return date_birth;
	}
	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}
	
	public List<ChapterRest> getChapters() {
		return chapters;
	}
	public void setChapters(List<ChapterRest> chapters) {
		this.chapters = chapters;
	}
	public List<TvShowRest> getTvShows() {
		return tvShows;
	}
	public void setTvShows(List<TvShowRest> tvShows) {
		this.tvShows = tvShows;
	}
	
	
}
