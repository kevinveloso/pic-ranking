package com.picranking.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.picranking.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
