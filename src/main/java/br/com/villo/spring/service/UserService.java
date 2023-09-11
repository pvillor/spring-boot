package br.com.villo.spring.service;

import org.springframework.stereotype.Service;

import br.com.villo.spring.model.User;
import br.com.villo.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(final User userData) {

        final User user = new User(userData.getName(), userData.getCpf(), userData.getEmail(), userData.getPassword(),
                userData.getType());

        return userRepository.save(user);
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }
}
