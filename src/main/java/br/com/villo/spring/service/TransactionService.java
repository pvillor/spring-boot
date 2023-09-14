package br.com.villo.spring.service;

import br.com.villo.spring.dto.CreateTransactionDto;
import br.com.villo.spring.model.Transaction;
public interface TransactionService {

    public Transaction createTransaction(final CreateTransactionDto transactionData);

    public Transaction retrieveTransaction(final long id);
}
