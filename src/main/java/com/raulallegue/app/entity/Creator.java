package com.raulallegue.app.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "creador", uniqueConstraints = {@UniqueConstraint(name = "uq_apellidos_nombre", columnNames = {"apellidos", "nombre"})})
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellidos;
    @OneToMany(mappedBy = "creador",fetch = FetchType.LAZY)
    private List<CreatorComic> creatorComicList;

}
