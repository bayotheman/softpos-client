//package com.up.softposclient.service.jpa;
//
//import com.tm30.softposcore.entities.configvalues.CardBin;
//import com.tm30.softposcore.repository.CardBinRepository;
//import com.tm30.softposcore.service.jpa.interfaces.CardBinJpaService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class CardBinJpaServiceImpl implements CardBinJpaService {
//
//	private final CardBinRepository repository;
//	@Override
//	public Optional<CardBin> findOne(Specification<CardBin> specification) {
//		return repository.findOne(specification);
//	}
//}
