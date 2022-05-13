package com.raulallegue.app.service;


import com.raulallegue.app.entity.ComicCopy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ComicCopyService {
    public List<ComicCopy> findAll();
    public Page<ComicCopy> findAll(Pageable pageable);
    public Optional<ComicCopy> findById(Long id);
    public ComicCopy save(ComicCopy comicCopy);
    public void deleteById(Long id);
    public ComicCopy update(Long id, LocalDate f_adquisicion, String estado,String tapa, Double precio);


}
