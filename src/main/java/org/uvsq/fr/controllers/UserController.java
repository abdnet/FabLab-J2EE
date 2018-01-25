package org.uvsq.fr.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uvsq.fr.entities.User;
import org.uvsq.fr.repositories.UserRepository;

import scala.remote;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id){
		return userRepository.findOne(id);
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable Long id){
		userRepository.delete(id);
		return (this.getUser(id)==null)?true:false;
	}
	@PostMapping("/user")
	public User createUser(User user){
		return userRepository.save(user);
	}
	@PutMapping("/user")
	public User UpdateUser(User user){
		return userRepository.save(user);
	}
}
