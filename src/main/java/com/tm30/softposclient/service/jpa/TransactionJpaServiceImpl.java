package com.tm30.softposclient.service.jpa;


import com.tm30.softposclient.entities.Transaction;
import com.tm30.softposclient.repositories.TransactionRepository;
import com.tm30.softposclient.service.jpa.interfaces.TransactionJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("transactionJpaService")
public class TransactionJpaServiceImpl implements TransactionJpaService {
	private final TransactionRepository repository;

	public void save(Transaction transaction){
		repository.save(transaction);
	}

	@Override
	public Optional<Transaction> findOne(Specification<Transaction> specification) {
		return repository.findOne(specification);
	}

	@Override
	public Page<Transaction> findAll(Specification<Transaction> specification, Pageable pageable) {
		return repository.findAll(specification,pageable);
	}

	@Override
	public List<Transaction> findAll() {
		return repository.findAll();
	}

	@Override
	public Page<Transaction> filter(Specification<Transaction> specification, Pageable pageable) {
		return repository.findAll(specification,pageable);
	}
}
