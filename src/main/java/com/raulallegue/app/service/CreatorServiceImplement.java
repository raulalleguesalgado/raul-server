package com.raulallegue.app.service;

import com.raulallegue.app.entity.Creator;
import com.raulallegue.app.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class CreatorServiceImplement implements CreatorService{

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    public List<Creator> findAll() {
        return creatorRepository.findAll();
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
/*



    @Override
    @Transactional(readOnly = true)
    public List<Collection> findAll() {
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
    public Long findByName(String name) {
        return userRepository.findIdByName(name);
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

    @Override
    @Transactional
	public Collection update(Long id, String nombre, String publicador) {
        Optional<Collection> collection = userRepository.findById(id);
        if (!collection.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Collection %d Not Found", id));
        }


        Collection toUpdate = collection.get();
        if (publicador != null && !publicador.isBlank()) {


            toUpdate.setPublicador(publicador);

        }

        if (nombre != null && !nombre.isBlank()) {

            toUpdate.setNombre(nombre);

        }

        return toUpdate;


    }
 */