package org.example.repository;

import org.example.model.Saga;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorySaga extends MongoRepository<Saga, Long> {
}
