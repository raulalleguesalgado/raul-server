package com.raulallegue.app.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ComicCopyDtoNew implements Serializable {
     private Long id;
     private LocalDate f_adquisicion;
    @NotBlank
     private String estado;
    @NotBlank
     private String tapa;
     private Double precio;
}
