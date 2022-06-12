package com.raulallegue.app.controller;

import com.raulallegue.app.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("convertEntityToDtoUtil")
public class ConvertEntityToDtoUtil {
  @Autowired
  private ModelMapper modelMapper;

  public ComicDTO convertEntityToDto(Comic comic) {
    return modelMapper.map(comic, ComicDTO.class);
  }
  public CreatorComicDTO convertEntityToDto(CreatorComic creatorComic) {
    return modelMapper.map(creatorComic, CreatorComicDTO.class);
  }
  public ComicDtoNew convertEntityToDtoNew(Comic comic){
    return modelMapper.map(comic, ComicDtoNew.class);
  }

  }



