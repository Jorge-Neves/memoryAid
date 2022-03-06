package memoryaid.model;

public class Card {

    private final String id;
    private final String question;
    private final String answer;
    private final String[] topics;
    private final String[] options;

    public Card(String id, String question, String answer, String[] topics, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.topics = topics;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getTopics() {
        return topics;
    }

    public String[] getOptions() {
        return options;
    }
}
