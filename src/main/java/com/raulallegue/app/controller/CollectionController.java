package com.raulallegue.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.service.CollectionService;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {
	
	@Autowired
	private CollectionService userService;
	
// Create a new user
	@PostMapping
	public Collection create ( @RequestBody Collection user) {

		return userService.save(user);
	}
	
	// Read an user
	@GetMapping("/{id}")
	public Collection read (@PathVariable(value = "id") Long userId) {
		Optional<Collection> oUser = userService.findById(userId);

		if(!oUser.isPresent()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, String.format("Collection %d Not Found", userId));
		}

		return oUser.get();
	}

	@GetMapping("/per/{name}")
	public Long readN (@PathVariable(value = "name") String name){
		System.out.println("entra en el metodo");
		Long id = userService.findByName(name);
		if(id == null){

			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, String.format("Collection  Not Found"));
		}
		System.out.println("llega");
			return id;




	}
	
	// Update an User
	@PutMapping("/{id}")
	public Collection update (@PathVariable(value = "id") Long userId, @RequestParam(required = false,value = "nombre")String nombre,@RequestParam(required = false,value = "publicador")String publicador) {
		return userService.update(userId,nombre,publicador);

	}
	
	// Delete an User
	@DeleteMapping("/{id}")
	public void delete (@PathVariable(value = "id") Long userId) {
		
		if(!userService.findById(userId).isPresent()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, String.format("Collection %d Not Found", userId));
		}
		
		userService.deleteById(userId);

	}
	
	// Read all Users
	@GetMapping
	public List<Collection> readAll () {
		

		
		return userService.findAll();
	}

}





