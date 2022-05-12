package com.raulallegue.app.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.raulallegue.app.entity.Creator;
import com.raulallegue.app.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/creators")
public class CreatorController {

@Autowired
    private CreatorService creatorService;


    @PostMapping
    public Creator create (@RequestBody Creator creator) {

        return creatorService.save(creator);
    }

    @GetMapping("/{id}")
    public Creator read (@PathVariable(value = "id") Long id) {
        Optional<Creator> creator = creatorService.findById(id);

        if(!creator.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Creator %d Not Found", id));
        }

        return creator.get();
    }

    @PutMapping("/{id}")
    public Creator update (@PathVariable(value = "id") Long id, @RequestParam(required = false,value = "nombre")String nombre,@RequestParam(required = false,value = "apellidos")String apellidos) {
        return creatorService.update(id,nombre,apellidos);

    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable(value = "id") Long id) {

        if(!creatorService.findById(id).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Collection %d Not Found", id));
        }

        creatorService.deleteById(id);

    }

    @GetMapping
    public List<Creator> readAll () {



        return creatorService.findAll();
    }



}
