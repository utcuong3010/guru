package com.bubanking.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubanking.common.domain.IPTransaction;

public interface IPTransactionRepository extends MongoRepository<IPTransaction, String>{
	
}
