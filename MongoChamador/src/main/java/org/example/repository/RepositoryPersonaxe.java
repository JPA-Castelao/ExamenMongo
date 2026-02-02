package org.example.repository;

import org.example.model.Personaxe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryPersonaxe extends MongoRepository<Personaxe, String> {
}
