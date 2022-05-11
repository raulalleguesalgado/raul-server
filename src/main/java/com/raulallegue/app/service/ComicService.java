package com.raulallegue.app.service;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.entity.Comic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComicService {

	public List<Comic> findAll();
	
	public Page<Comic> findAll(Pageable pageable);
	
	public Optional<Comic> findById(Long id);

	
	public Collection save(Comic comic);
	
	public void deleteById(Long id);

	public Collection update(Long id,String nombre, int numero);
	/*
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private int numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion", foreignKey = @ForeignKey(name = "fk_coleccion_comic"))
    private Collection collection;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY)
    private List<CreatorComic> creatorComicList;
    @OneToMany(mappedBy = "comic",fetch = FetchType.LAZY)
    private  List<ComicCopy>comicCopies;
	 */
}
