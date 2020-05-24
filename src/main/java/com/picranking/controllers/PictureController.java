package com.picranking.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.picranking.entities.Picture;
import com.picranking.services.PictureService;

@RestController
@RequestMapping("/pictures")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@GetMapping("")
	public List<Picture> listAll() {
		return pictureService.findAll();
	}
	
	@GetMapping("/{id}")
	public String getPicture(@PathVariable String id, Model model) {
		Picture picture = pictureService.findById(id);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(picture.getDate());
		
		model.addAttribute("tittle", picture.getTittle());
		model.addAttribute("theme", picture.getTheme());
		model.addAttribute("author", picture.getAuthor());
		model.addAttribute("year", cal.get(Calendar.YEAR));
		model.addAttribute("rating", picture.getRating());
		model.addAttribute("image", Base64.getEncoder().encodeToString(picture.getImage().getData()));
		
		return "picture";
	}
	
	@PostMapping("/add")
	public String addPicture(@RequestParam("tittle") String tittle,
			@RequestParam("theme") String theme, @RequestParam("author") String author,
			@RequestParam("date") String date, @RequestParam("image") MultipartFile image) throws IOException {
		
		Picture picture = new Picture();
		
		picture.setTittle(tittle);
		picture.setTheme(theme);
		picture.setAuthor(author);
		picture.setRating(0.0);
		
		try {
			Date d = new SimpleDateFormat("MM-dd-yyyy").parse(date);
			picture.setDate(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		picture.setImage(
		          new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		
		pictureService.save(picture);		
		
		return "redirect:/pictures/";
	}

}
