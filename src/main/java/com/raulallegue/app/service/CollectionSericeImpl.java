package com.raulallegue.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.repository.CollectionRepository;

@Service
public class CollectionSericeImpl implements CollectionService {

	@Autowired
	private CollectionRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Collection> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Collection> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Collection> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public Collection save(Collection user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
