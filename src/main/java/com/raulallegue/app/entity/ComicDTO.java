package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor
@NoArgsConstructor
public class ComicDTO {
    Long id;
    String nombre;
    Integer numero;
    Collection collection;
    List<CreatorComic> creatorComicList;
    List<ComicCopy> comicCopies;




}
