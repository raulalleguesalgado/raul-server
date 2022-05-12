package com.raulallegue.app.controller;

import com.raulallegue.app.entity.Comic;
import com.raulallegue.app.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PostMapping
    public Comic create(@RequestBody Comic comic) {

        return comicService.save(comic);

    }

    @GetMapping("{id}")
    public Comic read(@PathVariable(value = "id") Long id) {
        Optional<Comic> comic = comicService.findById(id);

        if (!comic.isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Comic %d Not Found", id));
        }
        return comic.get();
    }

    @GetMapping("/per/{name}")
    public Long readN (@PathVariable(value = "name") String name){

        Long id = comicService.findIdByName(name);
        if(id == null){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Comic  Not Found"));
        }

        return id;




    }
    @PutMapping("/{id}")
    public Comic update (@PathVariable(value = "id") Long id, @RequestParam(required = true,value = "nombre")String nombre,@RequestParam(required = true,value = "numero")int numero) {
        return comicService.update(id,nombre,numero);

    }


    @DeleteMapping("/{id}")
    public void delete (@PathVariable(value = "id") Long id) {
        if(!comicService.findById(id).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Comic %d Not Found", id));

        }
        comicService.deleteById(id);



    }
    @GetMapping
    public List<Comic> readAll(){

        return comicService.findAll();
    }






    }



