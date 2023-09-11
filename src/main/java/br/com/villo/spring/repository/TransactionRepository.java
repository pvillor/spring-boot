package br.com.villo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villo.spring.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
