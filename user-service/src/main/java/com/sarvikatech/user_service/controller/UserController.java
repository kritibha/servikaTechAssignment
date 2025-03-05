package com.sarvikatech.user_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvikatech.user_service.entity.User;
import com.sarvikatech.user_service.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "User Service Management", description = "Operations related to user accounts.")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/all")
	@Operation(summary = "Get All Users", description = "Retrieve all users list.")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping("/{id}")
	@Operation(summary = "Get User by ID", description = "Retrieve user details by their ID.")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/new")
    @Operation(summary = "Create a new user", description = "Add a new user to the h2 database USERS.")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user", description = "Editing an existing user to the system.")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the user", description = "Deleting the existing user from the system.")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "User deleted.";
    }
}
