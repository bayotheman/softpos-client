package com.tm30.softposclient.service.jpa.specification;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.entities.users.Acquirer;
import org.springframework.data.jpa.domain.Specification;

public final class MerchantJpaSpecification {
	private MerchantJpaSpecification(){}

	public static Specification<Merchant> equalsId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("id"), id);
		};
	}

	public static Specification<Merchant> equalsAcquirer(Acquirer acquirer){
		return (root, query, criteriaBuilder) -> {
			if(acquirer == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("acquirer"), acquirer);
		};
	}
	public static Specification<Merchant> equalsEmail(String email){
		return (root, query, criteriaBuilder) -> {
			if(email == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("email"), email);
		};
	}
}
