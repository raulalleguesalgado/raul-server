package com.raulallegue.app.repository;

import com.raulallegue.app.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<Comic,Long> {
    @Query("SELECT r.id FROM Comic r where r.nombre = :name")
    Long findIdByName(@Param("name") String name);
}
