package com.raulallegue.app.controller;

import com.raulallegue.app.entity.Comic;
import com.raulallegue.app.entity.ComicDTO;
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


}
