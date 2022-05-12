package com.raulallegue.app.repository;

import com.raulallegue.app.entity.CreatorComic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorComicRepository extends JpaRepository<CreatorComic, Long> {

}