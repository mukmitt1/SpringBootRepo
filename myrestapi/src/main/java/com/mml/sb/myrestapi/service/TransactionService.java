package com.mml.sb.myrestapi.service;


import org.springframework.stereotype.Service;

import com.mml.sb.myresapi.exceptions.AccountException;

@Service
public class TransactionService {
	//process transaction
	public String processTransaction() throws AccountException {
		throw new AccountException("Transaction declined. Credit Limit exceed");
	}
}
