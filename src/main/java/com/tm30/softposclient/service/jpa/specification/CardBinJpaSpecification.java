//package com.up.softposclient.service.jpa.specification;
//
//import com.tm30.softposcore.entities.Acquirer;
//import com.tm30.softposcore.entities.configvalues.CardBin;
//import org.springframework.data.jpa.domain.Specification;
//
//public final class CardBinJpaSpecification {
//	public static Specification<CardBin> equalsBin(String number){
//		return (root, query, criteriaBuilder) -> {
//			if(number == null) return criteriaBuilder.disjunction();
//			return criteriaBuilder.equal(root.get("number"), number);
//		};
//	}
//
//	public static Specification<CardBin> equalsAcquirer(Acquirer acquirer){
//		return (root, query, criteriaBuilder) -> {
//			if(acquirer == null) return criteriaBuilder.disjunction();
//			return criteriaBuilder.equal(root.get("acquirer"), acquirer);
//		};
//	}
//}
