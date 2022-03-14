package memoryaid.service;

import memoryaid.controller.CardsController;
import memoryaid.model.CardPackDocument;
import memoryaid.repository.CardPackRepository;

public class CardPackDocumentService {

    private final CardPackRepository cardPackRepository;

    public CardPackDocumentService(CardPackRepository cardPackRepository) {
        this.cardPackRepository = cardPackRepository;
    }

    public CardPackDocument saveCardPack(CardPackDocument cardPack) {
        return cardPackRepository.save(cardPack);
    }

    public CardPackDocument getCardPack(String id) {
        return cardPackRepository.findById(id).orElse(null);
    }
}
