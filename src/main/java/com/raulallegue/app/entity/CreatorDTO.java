package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CreatorDTO {
    Long id;
    String nombre;
    String apellidos;
    String trabajo;
    List<CreatorComicDTO> creatorComicList;

}
