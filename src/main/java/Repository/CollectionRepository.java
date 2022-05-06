package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer>{

}
