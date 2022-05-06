package Controller;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Entity.Collection;
import Service.CollectionService;

@RestController
@RequestMapping("/collections")
public class CollectionController {

	private CollectionService collectionService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Collection collection){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(collectionService.save(collection));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Integer id){
		
		collectionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Collection> readAll(){
		
		List<Collection>collections=StreamSupport.stream(collectionService.findAll().spliterator(), false).collect(Collectors.toList());
		return collections;
		
	}
	

	
	
	
}
