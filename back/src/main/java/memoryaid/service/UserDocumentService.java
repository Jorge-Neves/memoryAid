package memoryaid.service;

import memoryaid.model.UserDocument;
import memoryaid.repository.UserRepository;

public class UserDocumentService {

    private final UserRepository userRepository;

    public UserDocumentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDocument addUser( UserDocument user) {
        return userRepository.save(user);
    }

    public UserDocument getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
