package com.raulallegue.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raulallegue.app.entity.Collection;

public interface CollectionService {

	public List<Collection> findAll();
	
	public Page<Collection> findAll(Pageable pageable);
	
	public Optional<Collection> findById(Long id);
	public Long findByName(String name);


	
	public Collection save(Collection user);
	
	public void deleteById(Long id);
	public Collection update(Long id,String nombre, String publicador);
	
}
