package br.com.villo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villo.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsUserByCpf(final String cpf);

	boolean existsUserByEmail(final String email);
}
