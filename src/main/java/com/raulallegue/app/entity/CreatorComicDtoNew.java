package com.raulallegue.app.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreatorComicDtoNew implements Serializable {
   private   Long id;
     private CreatorDtoNew creador;
     private String trabajo;
}
