package com.raulallegue.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Integer numero;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "id_coleccion", foreignKey = @ForeignKey(name = "fk_coleccion_comic"))

    private Collection collection;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CreatorComic> creatorComicList;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  List<ComicCopy>comicCopies;

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", collection=" + collection +
                ", creatorComicList=" + creatorComicList +
                ", comicCopies=" + comicCopies +
                '}';
    }
}
