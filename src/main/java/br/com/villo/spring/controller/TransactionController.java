package br.com.villo.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villo.spring.dto.CreateTransactionDto;
import br.com.villo.spring.model.Transaction;
import br.com.villo.spring.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody final CreateTransactionDto transactionData) {

        final Transaction createdTransaction = transactionService.createTransaction(transactionData);

        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> retrieveTransaction(@PathVariable final String id) {

        final Transaction transaction = transactionService.retrieveTransaction(Long.parseLong(id));

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
