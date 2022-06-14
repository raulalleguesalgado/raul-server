package com.raulallegue.app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "creador_comic")//, uniqueConstraints = {@UniqueConstraint(name = "uq_creador_comic_trabajo", columnNames = {"id_comic", "id_creador","trabajo"})}
public class CreatorComic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @JsonBackReference(value = "comic2")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comic",foreignKey = @ForeignKey(name = "fk_creadorcomic_comic"))
    private Comic comic;



    @JsonBackReference(value = "creador2")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creador",foreignKey = @ForeignKey(name = "fk_creadorcomic_creador"))
    private Creator creador;

    private String trabajo;




}
