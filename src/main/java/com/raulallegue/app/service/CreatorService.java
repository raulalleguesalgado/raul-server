package com.raulallegue.app.service;

import com.raulallegue.app.entity.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CreatorService {
    public List<Creator> findAll();
    public Page<Creator> findAll(Pageable pageable);
    public Optional<Creator> findById(Long id);




    public Creator save(Creator creator);

    public void deleteById(Long id);

    public Creator update(Long id,String nombre, String apellidos);
}






