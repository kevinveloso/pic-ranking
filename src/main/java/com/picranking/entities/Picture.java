package com.picranking.entities;

import java.util.Date;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="pictures")
public class Picture {
	
	@Id
	private String id;
	
	private String tittle;
	
	private String theme;
	
	private String author;
	
	private Date date;
	
	private double rating;
	
	private double total;
	
	private int numOfVotes;
	
	private Binary image;

}
