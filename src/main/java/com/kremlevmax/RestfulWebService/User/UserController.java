package com.kremlevmax.RestfulWebService.User;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {
	
	UserDaoService userDaoService;


	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}
	
	@GetMapping("/users")
	private List<User> getAllUsers() {
		return userDaoService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	private User getOneUser(@PathVariable int id) {
		return userDaoService.getUserById(id);
	}
	
	@PostMapping("/users")
	private ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userDaoService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
