package com.everis.d4i.tutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CategoryRest implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	private Long id;
	private String name;

}
