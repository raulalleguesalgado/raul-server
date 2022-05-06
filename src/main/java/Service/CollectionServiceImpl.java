package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Entity.Collection;
import Repository.CollectionRepository;

@Service
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionRepository collectionRepository;
	@Override
	public Iterable<Collection> findAll() {
		// TODO Auto-generated method stub
		return collectionRepository.findAll();
	}

	@Override
	@Transactional
	public Collection save(Collection collection) {
		// TODO Auto-generated method stub
		return collectionRepository.save(collection);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		collectionRepository.deleteById(id);
		
	}

	@Override
	public Page<Collection> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return collectionRepository.findAll(pageable);
	}

}
