package com.mml.sb.myrestapi.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mml.sb.myresapi.exceptions.AccountException;
import com.mml.sb.myrestapi.model.Account;
import com.mml.sb.myrestapi.model.Transaction;
import com.mml.sb.myrestapi.service.TransactionService;


@RestController
public class AccountController {
	private TransactionService transactionService;
	
	
	public AccountController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}


	@GetMapping("/account/{cardNumber}")	
	public ResponseEntity<Account> getAccountDetails(@PathVariable String cardNumber) {
		Account act = new Account("2333342455", cardNumber, "Mark");		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("Account", "US")
				.body(act);
		//return act;
	}

	
	@GetMapping("/accounts")	
	public List<Account> getAccounts() {
		var accounts = new ArrayList<Account>();
		accounts.add(new Account("2333342455", "4322 1171 8228 6226", "Mark"));		
		accounts.add(new Account("3373737373", "5422 1171 8228 3735", "Mark"));		
		accounts.add(new Account("8383838383", "4000 1171 8228 8844", "Mark"));		
		return accounts;
	}


	@PostMapping("/authorization")	
	public ResponseEntity<?> transaction(@RequestBody(required=false) Transaction tran) {
			try {
				transactionService.processTransaction();
				return ResponseEntity
						.status(HttpStatus.ACCEPTED)
						.body("Successfully processed");

			} catch (AccountException e) {
				// TODO Auto-generated catch block
				return ResponseEntity
						.status(HttpStatus.NOT_ACCEPTABLE)
						.body(e.getMessage());
			}
	}
}
