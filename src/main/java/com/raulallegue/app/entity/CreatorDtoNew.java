package com.raulallegue.app.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CreatorDtoNew implements Serializable {
     private Long id;
    @NotBlank
     private String nombre;
    @NotBlank
     private String apellidos;
}
