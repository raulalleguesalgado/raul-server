package com.raulallegue.app.config;

import com.raulallegue.app.entity.Collection;
import com.raulallegue.app.repository.CollectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class ComoQuieras implements CommandLineRunner {


        private final CollectionRepository collectionRepository;

        public ComoQuieras(CollectionRepository repository) {
            this.collectionRepository = repository;
        }

        @Override
        public void run(String... args) throws Exception {
            Collection collection = new Collection();
            collection.setNombre("Marvel 1");

            collection.setPublicador("Marvel Comics");
            collectionRepository.save(collection);
        }

}
