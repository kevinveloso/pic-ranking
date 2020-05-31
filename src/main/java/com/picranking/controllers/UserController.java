package com.picranking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.picranking.entities.User;
import com.picranking.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/{id}")
	public String getPicture(@PathVariable String id, Model model) {
		User user = userService.findById(id);
		
		model.addAttribute("name", user.getName());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("email", user.getEmail());
		
		return "user";
	}
	
	@PostMapping("/add")
	public String addUser(@RequestParam("name") String name,
			@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		User user = new User();

		if (userService.findByEmail(email) != null || userService.findByEmail(username) != null) {
			throw new RuntimeException("Username or Email already in use! Choose another one!");
		}
		
		user.setName(name);
		user.setUsername(username);
		user.setEmail(email);
		
		String securePassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
		user.setPassword(securePassword);
	
		userService.save(user);
		
		return "redirect: /user/" + user.getId();
	}	
	
}
