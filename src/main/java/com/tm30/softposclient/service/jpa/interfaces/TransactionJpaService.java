package com.tm30.softposclient.service.jpa.interfaces;


import com.tm30.softposclient.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface TransactionJpaService extends JpaService<Transaction> {

	Page<Transaction> filter(Specification<Transaction> specification, Pageable pageable);
}
