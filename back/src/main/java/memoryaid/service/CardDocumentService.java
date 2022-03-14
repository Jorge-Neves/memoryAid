package memoryaid.service;

import memoryaid.model.CardDocument;
import memoryaid.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CardDocumentService {

    private final CardRepository cardRepository;

    public CardDocumentService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void saveCard(CardDocument cardDocument){
        cardRepository.save(cardDocument);
    }

    public List<String> saveAllCards( List<CardDocument> cards) {
        return cardRepository.saveAll(cards).stream().map(CardDocument::getId).collect(Collectors.toList());
    }

    public List<CardDocument> getAllCards(){
        return cardRepository.findAll();
    }

    public List<CardDocument> getAllCardsById(List<String> cardIds) {
        return (List<CardDocument>) Optional.of(cardRepository.findAllById(cardIds)).orElse(List.of());
    }

    public CardDocument getCardById(String id){
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Could not find Card with id %s", id)
        ));
    }

    public void deleteCard(String id){
        cardRepository.deleteById(id);
    }
}
