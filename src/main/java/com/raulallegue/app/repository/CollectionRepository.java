package com.raulallegue.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raulallegue.app.entity.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

}
