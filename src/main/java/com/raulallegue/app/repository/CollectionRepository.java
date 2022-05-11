package com.raulallegue.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raulallegue.app.entity.Collection;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    @Query("SELECT r.id FROM Collection r where r.nombre = :name")
    Long findIdByName(@Param("name") String name);
}
