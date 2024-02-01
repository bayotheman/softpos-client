//package com.up.softposclient.service.core;
//
//import com.tm30.softposcore.entities.Acquirer;
//import com.tm30.softposcore.entities.configvalues.CardBin;
//import com.tm30.softposcore.service.core.interfaces.CardBinService;
//import com.tm30.softposcore.service.jpa.interfaces.CardBinJpaService;
//import com.tm30.softposcore.service.jpa.specification.CardBinJpaSpecification;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
///**
// * @author Adebayo.A.Okutubo
// */
//@Service
//@RequiredArgsConstructor
//public class CardBinServiceImpl implements CardBinService {
//	private final CardBinJpaService service;
//
//	@Override
//	public void save(CardBin domain) {
//		service.save(domain);
//	}
//
//	@Override
//	public CardBin findOne(Acquirer acquirer, String number) {
//		Specification<CardBin> specification = Specification.where(CardBinJpaSpecification.equalsAcquirer(acquirer)
//				.and(CardBinJpaSpecification.equalsBin(number)));
//		Optional<CardBin> optionalCardBin =  service.findOne(specification);
//		return optionalCardBin.orElseThrow();
//	}
//}
