package com.raulallegue.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "comic", uniqueConstraints = {@UniqueConstraint(name = "uq_numero_idcoleccion", columnNames = {"id_coleccion", "numero"})})
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private int numero;
    @JsonIgnore @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion", foreignKey = @ForeignKey(name = "fk_coleccion_comic"))
    private Collection collection;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY)
    private List<CreatorComic> creatorComicList;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY)
    private  List<ComicCopy>comicCopies;

}
