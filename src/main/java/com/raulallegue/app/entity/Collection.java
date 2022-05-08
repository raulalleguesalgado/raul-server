package com.raulallegue.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
@Entity
@Table(name = "coleccion",uniqueConstraints = {@UniqueConstraint(name = "uq_nombre", columnNames = "nombre")})
public class Collection implements Serializable{

	


	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	 @NotBlank private String nombre;
	
	@NotBlank private String publicador;


	
	
	

	


	
}
