package com.raulallegue.app.service;

import com.raulallegue.app.entity.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class CreatorServiceImplement implements CreatorService{
    @Override
    public List<Creator> findAll() {
        return null;
    }

    @Override
    public Page<Creator> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Creator> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long findIdByName(String nombre) {
        return null;
    }

    @Override
    public Creator save(Creator creator) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Creator update(Long id, String nombre, String apellidos) {
        return null;
    }
}
