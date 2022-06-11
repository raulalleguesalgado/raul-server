package com.raulallegue.app.controller;

import com.raulallegue.app.entity.CreatorComic;
import com.raulallegue.app.entity.CreatorComicDTO;
import com.raulallegue.app.service.CreatorComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creatorComic")
public class CreatorComicController {
    @Autowired
    private CreatorComicService creatorComicService;

    @PostMapping
    public CreatorComic create(@RequestBody CreatorComic creatorComic) {

        return creatorComicService.save(creatorComic);

    }
    @GetMapping("{id}")
    public CreatorComic read(@PathVariable(value = "id") Long id) {
        Optional<CreatorComic> creatorComic = creatorComicService.findById(id);

        if (!creatorComic.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("ComicCreator %d Not Found", id));
        }
        return creatorComic.get();
    }

    @PutMapping("/{id}")
    public CreatorComic update(@PathVariable(value = "id") Long id, @RequestParam(required = false, value = "trabajo") String trabajo) {
        return creatorComicService.update(id,trabajo);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        if (!creatorComicService.findById(id).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("ComicCreator %d Not Found", id));

        }
        creatorComicService.deleteById(id);


    }

    @GetMapping
    public List<CreatorComic> readAll() {

        return creatorComicService.findAll();
    }
    private CreatorComicDTO convertToDTO(){
        return null;

    }


}
