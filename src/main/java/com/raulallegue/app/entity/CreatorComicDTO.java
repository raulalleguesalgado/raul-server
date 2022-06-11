package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CreatorComicDTO {
    private Long id;
    private ComicDTO comic;
    private CreatorDTO creador;
    private String trabajo;


}
