package com.raulallegue.app.service;

import com.raulallegue.app.entity.CreatorComic;
import com.raulallegue.app.entity.CreatorComicDTO;
import com.raulallegue.app.entity.CreatorComicDtoNew;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CreatorComicService {
    public List<CreatorComic> findAll();
    public List<CreatorComicDtoNew>findAllDTONew();

    public Page<CreatorComic> findAll(Pageable pageable);
    public Optional<CreatorComic> findById(Long id);
    public CreatorComic save(CreatorComic creatorComic);
    public void deleteById(Long id);
    public CreatorComic update(Long id,String trabajo);


}
