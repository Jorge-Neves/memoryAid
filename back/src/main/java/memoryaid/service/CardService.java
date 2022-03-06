package memoryaid.service;

import memoryaid.model.Card;
import memoryaid.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void addCard(Card card){
        cardRepository.insert(card);
    }

    public void updateCard(){

    }

    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    public Card getCardById(String id){
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Could not find Card with id %s", id)
        ));
    }

    public void deleteCard(String id){
        cardRepository.deleteById(id);
    }
}
