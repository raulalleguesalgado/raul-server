package com.raulallegue.app.service;

import com.raulallegue.app.entity.CreatorComic;
import com.raulallegue.app.entity.CreatorComicDTO;
import com.raulallegue.app.repository.CreatorComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorComicImplement implements CreatorComicService {
    @Autowired
    private CreatorComicRepository creatorComicRepository;

    @Override
    public List<CreatorComic> findAll() {
        return creatorComicRepository.findAll();
    }

    @Override
    public Page<CreatorComic> findAll(Pageable pageable) {
        return creatorComicRepository.findAll(pageable);
    }

    @Override
    public Optional<CreatorComic> findById(Long id) {
        return creatorComicRepository.findById(id);
    }

    @Override
    public CreatorComic save(CreatorComic creatorComic) {
        return creatorComicRepository.save(creatorComic);
    }

    @Override
    public void deleteById(Long id) {
        creatorComicRepository.deleteById(id);
    }

    @Override
    public CreatorComic update(Long id, String trabajo) {
        Optional<CreatorComic> creatorComic = creatorComicRepository.findById(id);
        if (!creatorComic.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("CreatorComic %d Not Found", id));

        }
        CreatorComic toUpdate = creatorComic.get();

        if (trabajo != null && !trabajo.isBlank()) {

            toUpdate.setTrabajo(trabajo);

        }

        creatorComicRepository.save(toUpdate);
        return toUpdate;
    }



}
