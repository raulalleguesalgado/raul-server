package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "coleccion", uniqueConstraints = {@UniqueConstraint(name = "uq_nombre", columnNames = "nombre")})
public class Collection implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String nombre;

    @NotBlank
    private String publicador;

	@OneToMany(mappedBy = "collection",fetch = FetchType.LAZY)
	private List<Comic> comics;


}
