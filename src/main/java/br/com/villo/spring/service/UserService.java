package br.com.villo.spring.service;

import org.springframework.stereotype.Service;

import br.com.villo.spring.dto.CreateDepositDto;
import br.com.villo.spring.dto.UserDto;
import br.com.villo.spring.model.User;
import br.com.villo.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(final UserDto userData) {

        final User newUser = new User(userData.getName(), userData.getCpf(), userData.getEmail(), userData.getPassword(),
                userData.getType());

        return userRepository.save(newUser);
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }

    public User retrieveUser(final long id) throws Exception {

        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User updateUser(final UserDto userData, final long id) throws Exception {
        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        foundUser.setName(userData.getName());
        foundUser.setCpf(userData.getCpf());
        foundUser.setEmail(userData.getEmail());
        foundUser.setPassword(userData.getPassword());
        foundUser.setType(userData.getType());

        return userRepository.save(foundUser);
    }

    public void deleteUser(final long id) throws Exception {
        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(foundUser);
    }

    public User createDeposit(final CreateDepositDto depositData, final long id) throws Exception {

        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        final float currentBalance = foundUser.getBalance();

        foundUser.setBalance(currentBalance + depositData.getValue());

        return userRepository.save(foundUser);
    }
}
