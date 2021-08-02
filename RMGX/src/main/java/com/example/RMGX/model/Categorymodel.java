package com.example.RMGX.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorymodel {
	@JsonProperty("id")
    private Long id;
	
	
	@JsonProperty("name")
	private String name;
	
	
	@JsonProperty("description")
	private String description;
}
