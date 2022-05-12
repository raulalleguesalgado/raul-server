package com.raulallegue.app.service;

import com.raulallegue.app.entity.Creator;
import com.raulallegue.app.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorServiceImplement implements CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    public List<Creator> findAll() {
        return creatorRepository.findAll();
    }

    @Override
    public Page<Creator> findAll(Pageable pageable) {
        return creatorRepository.findAll(pageable);
    }

    @Override
    public Optional<Creator> findById(Long id) {
        return creatorRepository.findById(id);
    }


    @Override
    public Creator save(Creator creator) {
        return creatorRepository.save(creator);
    }

    @Override
    public void deleteById(Long id) {
        creatorRepository.deleteById(id);

    }

    @Override
    @Transactional
    public Creator update(Long id, String nombre, String apellidos) {
        Optional<Creator> creator = creatorRepository.findById(id);
        if (!creator.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Creator %d Not Found", id));
        }
        Creator toUpdate = creator.get();

        if(nombre!=null && !nombre.isBlank()){

            toUpdate.setNombre(nombre);
        }

        if(apellidos!=null && !apellidos.isBlank()){

            toUpdate.setApellidos(apellidos);
        }

        return toUpdate;
    }
}
