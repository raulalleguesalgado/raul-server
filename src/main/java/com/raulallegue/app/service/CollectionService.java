package com.raulallegue.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raulallegue.app.entity.Collection;

public interface CollectionService {

	public Iterable<Collection> findAll();
	
	public Page<Collection> findAll(Pageable pageable);
	
	public Optional<Collection> findById(Long id);
	
	public Collection save(Collection user);
	
	public void deleteById(Long id);
	
}
