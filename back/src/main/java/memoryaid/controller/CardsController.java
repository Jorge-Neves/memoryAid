package memoryaid.controller;

import memoryaid.model.CardDocument;
import memoryaid.service.CardDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

    private final CardDocumentService cardDocumentService;
    private final Logger LOGGER = LoggerFactory.getLogger(CardsController.class);

    public CardsController(CardDocumentService cardDocumentService) {
        this.cardDocumentService = cardDocumentService;
    }

    @PostMapping
    public ResponseEntity saveCard(@RequestBody CardDocument cardDocument){
        cardDocumentService.saveCard(cardDocument);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "/save-all")
    public ResponseEntity<List<String>> saveCards(@RequestBody List<CardDocument> cards) {
        List<String> cardIds = cardDocumentService.saveAllCards(cards);
        return ResponseEntity.ok(cardIds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDocument> getCardById(@PathVariable String id){
        return ResponseEntity.ok(cardDocumentService.getCardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable String id){
        cardDocumentService.deleteCard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
