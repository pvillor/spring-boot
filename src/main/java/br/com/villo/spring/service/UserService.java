package br.com.villo.spring.service;

import br.com.villo.spring.dto.CreateDepositDto;
import br.com.villo.spring.dto.UserDto;
import br.com.villo.spring.model.User;

import java.util.List;

public interface UserService {

    public User createUser(final UserDto userData);

    public List<User> readUsers();

    public User retrieveUser(final long id);

    public User updateUser(final UserDto userData, final long id);

    public void deleteUser(final long id);

    public User createDeposit(final CreateDepositDto depositData, final long id);
}
