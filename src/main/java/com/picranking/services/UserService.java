package com.picranking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picranking.entities.User;
import com.picranking.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findById(String id) {
		return userRepository.findById(id).get();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
