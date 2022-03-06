package memoryaid;

import memoryaid.repository.CardRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MemoryAidApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryAidApplication.class, args);
	}

}
