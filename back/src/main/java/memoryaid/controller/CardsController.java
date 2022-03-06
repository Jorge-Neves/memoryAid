package memoryaid.controller;

import memoryaid.model.Card;
import memoryaid.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

    private final CardService cardService;

    public CardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity addCard(@RequestBody Card card){
        cardService.addCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable String id){
        cardService.deleteCard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
