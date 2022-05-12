package com.raulallegue.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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


	@OneToMany(mappedBy = "collection",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Comic> comics;



}
