package com.raulallegue.app.controller;

import com.raulallegue.app.entity.ComicCopy;
import com.raulallegue.app.service.ComicCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comicCopies")
public class ComicCopyController {
    @Autowired
    private ComicCopyService comicCopyService;

    @PostMapping
 public ComicCopy create(@RequestBody ComicCopy comicCopy) {

  return comicCopyService.save(comicCopy);

 }

 @GetMapping("{id}")
 public ComicCopy read(@PathVariable(value = "id") Long id) {
  Optional<ComicCopy> comicCopy = comicCopyService.findById(id);

  if (!comicCopy.isPresent()) {

   throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, String.format("ComicCopy %d Not Found", id));
  }
  return comicCopy.get();
 }

 @PutMapping("/{id}")
 public ComicCopy update(@PathVariable(value = "id") Long id, @RequestParam(required = false, value = "f_adquisicion") LocalDate f_adquisicion, @RequestParam(required = false, value = "estado") String estado,@RequestParam(required = false, value = "tapa") String tapa,@RequestParam(required = false, value = "precio") Double precio) {
  return comicCopyService.update(id, f_adquisicion, estado,tapa,precio);

 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable(value = "id") Long id) {
  if (!comicCopyService.findById(id).isPresent()) {
   throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, String.format("ComicCopy %d Not Found", id));

  }
  comicCopyService.deleteById(id);


 }
 @GetMapping
 public List<ComicCopy> readAll() {

  return comicCopyService.findAll();
 }



}
