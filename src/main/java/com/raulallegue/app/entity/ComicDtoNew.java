package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ComicDtoNew implements Serializable {
     private Long id;
    @NotBlank
     private String nombre;
    @NotNull
     private Integer numero;
     private CollectionDtoNew collection;
     private List<CreatorComicDtoNew> creatorComicList;
     private List<ComicCopyDtoNew> comicCopies;
}
