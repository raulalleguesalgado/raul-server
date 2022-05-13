package com.raulallegue.app.service;

import com.raulallegue.app.entity.ComicCopy;
import com.raulallegue.app.repository.ComicCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComicCopyServiceImplement implements ComicCopyService {

    @Autowired
    private ComicCopyRepository comicCopyRepository;


    @Override
    public List<ComicCopy> findAll() {
        return comicCopyRepository.findAll();
    }

    @Override
    public Page<ComicCopy> findAll(Pageable pageable) {
        return comicCopyRepository.findAll(pageable);
    }

    @Override
    public Optional<ComicCopy> findById(Long id) {
        return comicCopyRepository.findById(id);
    }

    @Override
    public ComicCopy save(ComicCopy comicCopy) {
        return comicCopyRepository.save(comicCopy);
    }

    @Override
    public void deleteById(Long id) {
        comicCopyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ComicCopy update(Long id, LocalDate f_adquisicion, String estado, String tapa, Double precio) {
        Optional<ComicCopy>comicCopy =comicCopyRepository.findById(id);

        if (!comicCopy.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Comic %d Not Found", id));
        }
        ComicCopy toUpdate = comicCopy.get();
        if(f_adquisicion!=null){
            toUpdate.setF_adquisicion(f_adquisicion);

        }
        if(estado!= null && !estado.isBlank()){

            toUpdate.setEstado(estado);

        }
        if(tapa!= null && !tapa.isBlank()){

            toUpdate.setTapa(tapa);
        }
        if(precio !=null && precio!=0){

            toUpdate.setPrecio(precio);
        }
        comicCopyRepository.save(toUpdate);

        return toUpdate;
    }


}
