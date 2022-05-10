package com.raulallegue.app.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ejemplar")
public class ComicCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private LocalDate f_adquisicion;
    @NotBlank
    private String estado;
    @NotBlank
    private String tapa;
    @NotBlank
    private Double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comic", foreignKey = @ForeignKey(name = "fk_Comic_ComicCopy"))
    private Comic comic;

}
