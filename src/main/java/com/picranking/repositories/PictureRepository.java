package com.picranking.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.picranking.entities.Picture;

@Repository
public interface PictureRepository extends MongoRepository<Picture, String> {

	List<Picture> findAllByAuthor(String author);

	List<Picture> findAllByTittle(String tittle);

	List<Picture> findAllByTheme(String theme);

}
