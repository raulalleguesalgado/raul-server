package com.raulallegue.app.service;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.entity.Comic;
import com.raulallegue.app.entity.ComicDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ComicService {

	public List<Comic> findAll();
	public List<ComicDTO> findAllDTO();
	
	public Page<Comic> findAll(Pageable pageable);
	
	public Optional<Comic> findById(Long id);

	public Long findIdByName(String nombre);

	public Comic save(Comic comic);
	
	public void deleteById(Long id);

	public Comic update(Long id,String nombre, Integer numero);

}
