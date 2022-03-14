package memoryaid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("card-packs")
public class CardPackDocument {

    @Id
    private final String id;
    private final String name;
    private final CardPackType type;
    private final List<String> cardIds;

    public CardPackDocument(String id, String name, CardPackType type, List<String> cardIds) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cardIds = cardIds;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CardPackType getType() {
        return type;
    }

    public List<String> getCardIds() {
        return cardIds;
    }
}
