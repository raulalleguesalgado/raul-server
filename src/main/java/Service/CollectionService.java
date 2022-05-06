package Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Entity.Collection;

public interface CollectionService {
	
	public Iterable<Collection> findAll();
	public Collection save(Collection collection);
	public void deleteById(int id);
	public Page<Collection> findAll(Pageable pageable);

}
