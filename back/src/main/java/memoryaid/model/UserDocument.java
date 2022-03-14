package memoryaid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
public class UserDocument {

    @Id
    private final String id;
    private final String username;
    private final String password;
    private final List<String> cardPackIds;

    public UserDocument(String id, String username, String password, List<String> cardPackIds) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cardPackIds = cardPackIds;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getCardPackIds() {
        return cardPackIds;
    }
}
