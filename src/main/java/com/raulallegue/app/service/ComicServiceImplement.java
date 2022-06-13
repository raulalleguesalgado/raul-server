package com.raulallegue.app.service;

import com.raulallegue.app.controller.ConvertEntityToDtoUtil;
import com.raulallegue.app.entity.*;
import com.raulallegue.app.repository.ComicRepository;
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
public class ComicServiceImplement implements ComicService {

    @Autowired
    private ComicRepository comicRepository;
    @Autowired
    private ConvertEntityToDtoUtil convertEntityToDtoUtil;

    @Override
    public List<Comic> findAll() {


        return comicRepository.findAll();
    }

    @Override
    public List<ComicDTO> findAllDTO() {
        List<ComicDTO>comicsdto;
        List<Comic>comics=comicRepository.findAll();

        comicsdto=comics.stream().map(comic -> convertEntityToDtoUtil.convertEntityToDto(comic)).collect(java.util.stream.Collectors.toList());
        return comicsdto;
    }

    @Override
    public List<ComicDtoNew> findAllDTONew() {
        List<ComicDtoNew>comicsdto;
        List<Comic>comics=comicRepository.findAll();
        comicsdto=comics.stream().map(comic -> convertEntityToDtoUtil.convertEntityToDtoNew(comic)).collect(java.util.stream.Collectors.toList());

        return comicsdto;
    }

    @Override
    public Page<Comic> findAll(Pageable pageable) {
        return comicRepository.findAll(pageable);
    }

    @Override
    public Optional<Comic> findById(Long id) {
        return comicRepository.findById(id);
    }

    @Override
    public Long findIdByName(String nombre) {
        return comicRepository.findIdByName(nombre);
    }

    @Override
    public Comic save(Comic comic) {
for (CreatorComic creatorComic : comic.getCreatorComicList()) {
    creatorComic.setComic(comic);
for(ComicCopy comicCopy:comic.getComicCopies()){
    comicCopy.setComic(comic);
}
}
        return comicRepository.save(comic);
    }

    @Override
    public void deleteById(Long id) {
        comicRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Comic update(Long id, String nombre, Integer numero) {

        Optional<Comic> comic = comicRepository.findById(id);
        if (!comic.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Comic %d Not Found", id));
        }
        Comic toUpdate = comic.get();

        if (nombre != null && !nombre.isBlank()) {

            toUpdate.setNombre(nombre);
        }
        if (numero !=null && numero!=0) {

            toUpdate.setNumero(numero);
        }
        comicRepository.save(toUpdate);

        return toUpdate;
    }














}
