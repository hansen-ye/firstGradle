package com.hansen.model.Attraction;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hansen.cnst.AttractionEnum;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "attractions")
public class Attraction {

	@Id
	@ApiModelProperty(notes = "id")
	private Long id;

	@ApiModelProperty(notes = "景點類別")
	private AttractionEnum attractionEnum;

	@ApiModelProperty(notes = "國家")
	private String country;

	@ApiModelProperty(notes = "名稱")
	private String name;

	@ApiModelProperty(notes = "經緯度")
	private Float[] loc;

	public Attraction(Long id, AttractionEnum attractionEnum, String country, String name, Float[] loc) {
		this.id = id;
		this.attractionEnum = attractionEnum;
		this.country = country;
		this.name = name;
		this.loc = loc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AttractionEnum getAttractionEnum() {
		return attractionEnum;
	}

	public void setAttractionEnum(AttractionEnum attractionEnum) {
		this.attractionEnum = attractionEnum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float[] getLoc() {
		return loc;
	}

	public void setLoc(Float[] loc) {
		this.loc = loc;
	}

}
