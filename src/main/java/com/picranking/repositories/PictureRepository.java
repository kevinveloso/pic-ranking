package com.picranking.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.picranking.entities.Picture;

@Repository
public interface PictureRepository extends MongoRepository<Picture, String> {

	public List<Picture> findAllByAuthor(String author);

	public List<Picture> findAllByTittle(String tittle);

	public List<Picture> findAllByTheme(String theme);

}
