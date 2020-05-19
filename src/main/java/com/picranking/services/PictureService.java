package com.picranking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picranking.entities.Picture;
import com.picranking.repositories.PictureRepository;

@Service
public class PictureService {
	
	@Autowired
	private PictureRepository pictureRepository;
	
	public List<Picture> findAll() {
		return pictureRepository.findAll();
	}
	
	public List<Picture> findAllByAuthor(String author) {
		return pictureRepository.findAllByAuthor(author);
	}
	
	public List<Picture> findAllByTittle(String tittle) {
		return pictureRepository.findAllByTittle(tittle);
	}
	
	public List<Picture> findAllByTheme(String theme) {
		return pictureRepository.findAllByTheme(theme);
	}
	
	public Optional<Picture> findById(String id) {
		return pictureRepository.findById(id);
	}
	
	public void save(Picture pic) {
		pictureRepository.save(pic);
	}
	
	public void delete(Picture pic) {
		pictureRepository.delete(pic);
	}
}
