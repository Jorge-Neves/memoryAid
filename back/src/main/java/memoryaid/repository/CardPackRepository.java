package memoryaid.repository;

import memoryaid.model.CardPackDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPackRepository extends MongoRepository<CardPackDocument, String> {
}
