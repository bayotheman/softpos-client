package com.tm30.softposclient.service.jpa.specification;

import com.tm30.softposclient.entities.users.Acquirer;
import org.springframework.data.jpa.domain.Specification;

public final class AcquirerJpaSpecification {

	private AcquirerJpaSpecification(){
	}

	public static Specification<Acquirer> equalsId(String id){
		return (root, query, criteriaBuilder) -> {
			if(id == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("id"), id);
		};
	}

//	public static Specification<Acquirer> equalsUid(String uid){
//		return (root, query, criteriaBuilder) -> {
//			if(uid == null) return criteriaBuilder.disjunction();
//			return criteriaBuilder.equal(root.get("uid"), uid);
//		};
//	}


	public static Specification<Acquirer> equalsEmail(String email){
		return (root, query, criteriaBuilder) -> {
			if(email == null) return criteriaBuilder.disjunction();
			return criteriaBuilder.equal(root.get("email"), email);
		};
	}
}
