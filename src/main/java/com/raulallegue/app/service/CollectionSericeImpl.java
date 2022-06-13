package com.raulallegue.app.service;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionSericeImpl implements CollectionService {

    @Autowired
    private CollectionRepository userRepository;

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
        userRepository.save(toUpdate);

        return toUpdate;


    }

    @Override
    @Transactional
    public Collection updateI(Long id, MultipartFile file) throws IOException {
        Optional<Collection> collection = userRepository.findById(id);
        if (!collection.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Collection %d Not Found", id));
        }


        Collection toUpdate = collection.get();
        if (file == null || file.isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, String.format("Image not found", id));
        }

        if(file.getSize() > 1000000){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, String.format("Image too big", id));
        }
        toUpdate.setImage(file.getBytes());
        toUpdate.setImagenContentType(file.getContentType());

userRepository.save(toUpdate);
        return toUpdate;
    }

}
