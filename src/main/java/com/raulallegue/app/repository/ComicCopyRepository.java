package com.raulallegue.app.repository;

import com.raulallegue.app.entity.ComicCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicCopyRepository extends JpaRepository<ComicCopy, Long> {
}