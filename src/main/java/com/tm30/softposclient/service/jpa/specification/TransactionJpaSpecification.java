package com.tm30.softposclient.service.jpa.specification;

import com.tm30.softposclient.entities.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public final class TransactionJpaSpecification {

	private TransactionJpaSpecification(){}

	public static Specification<Transaction> equalsId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.equal(root.get("id"), id);
		};
	}

	public static Specification<Transaction> equalsReference(String reference){
		return (root, query, criteriaBuilder) -> {
			if(reference == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.equal(root.get("reference"), reference);
		};
	}

	public static Specification<Transaction> likeReference(String reference){
		return (root, query, criteriaBuilder) -> {
			if(reference == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.like(root.get("reference"), "%" + reference + "%");
		};
	}

	public static Specification<Transaction> equalsAcquirerId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("acquirerId"), id);
		};
	}


	public static Specification<Transaction> equalsTerminalId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.equal(root.get("terminalId"), id);
		};
	}

	public static Specification<Transaction> likeTerminalId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.like(root.get("terminalId"), "%" + id + "%");
		};
	}

	public static Specification<Transaction> equalsMerchantId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.equal(root.get("merchantId"), id);
		};
	}

	public static Specification<Transaction> likeMerchantId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.like(root.get("merchantId"), "%" + id + "%");
		};
	}

	public static Specification<Transaction> isBetween(LocalDateTime start, LocalDateTime end){
		return (root, query, criteriaBuilder) -> {
			if(start == null || end == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.between(root.get("timeCompleted"), start, end);
		};
	}

	public static Specification<Transaction> likeTimeCompleted(String time){
		return (root, query, criteriaBuilder) -> {
			if(time == null) return criteriaBuilder.conjunction();
			return criteriaBuilder.like(root.get("timeCompleted"), "%" + time + "%");
		};
	}

}
