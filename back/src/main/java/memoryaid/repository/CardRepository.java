package memoryaid.repository;

import memoryaid.model.CardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository  extends MongoRepository<CardDocument, String> {
}
