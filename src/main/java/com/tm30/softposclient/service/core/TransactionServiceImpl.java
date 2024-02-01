package com.tm30.softposclient.service.core;

import com.tm30.softposclient.entities.Transaction;
import com.tm30.softposclient.model.paging.PageInfo;
import com.tm30.softposclient.model.paging.PageInfoImpl;
import com.tm30.softposclient.model.payload.*;
import com.tm30.softposclient.entities.users.Acquirer;

import com.tm30.softposclient.service.core.interfaces.TransactionService;
import com.tm30.softposclient.service.jpa.interfaces.AcquirerJpaService;
import com.tm30.softposclient.service.jpa.interfaces.TransactionJpaService;
import com.tm30.softposclient.service.jpa.specification.AcquirerJpaSpecification;
import com.tm30.softposclient.service.jpa.specification.TransactionJpaSpecification;
import com.tm30.softposclient.utils.JsonStringParserUtils;
import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionJpaService transactionJpaService;
	private final AcquirerJpaService acquirerService;

//	public ResponseEntity<Response<CustomCollection<?>>> filter(Principal principal, FilterRequest request){
//		Acquirer acquirer = getAcquirer(principal);
//
//		Specification<Transaction> specification = Specification.where(TransactionJpaSpecification.equalsAcquirerId(acquirer.getCbnId())
//				.and(TransactionJpaSpecification.equalsMerchantId(request.getMerchantId()))
//				.and(TransactionJpaSpecification.equalsReference(request.getReference()))
//				.and(TransactionJpaSpecification.equalsTerminalId(request.getTerminalId()))
//				.and(TransactionJpaSpecification.isBetween(request.getStartDate(), request.getEndDate()))
//		);
//
//		CustomCollection<?> collection = getCollection(specification, request.getPage(), request.getSize());
//		Response<CustomCollection<?>> response = ResponseImpl.create(true, collection, "successful");
//
//		return ResponseEntity.ok(response);
//
//	}

	public ResponseEntity<Response<CustomCollection<?>>> filter(HttpServletRequest request) throws IOException {
		Principal principal = request.getUserPrincipal();
		Acquirer acquirer = getAcquirer(principal);

		String stringBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
		RequestImpl<FilterRequest> body = JsonStringParserUtils.convertJsonStringToObjectType(stringBody,
				RequestImpl.class);

		FilterRequest filter = body.getBody();

		Specification<Transaction> specification = Specification.where(TransactionJpaSpecification.equalsAcquirerId(acquirer.getCbnId())
				.and(TransactionJpaSpecification.equalsMerchantId(filter.getMerchantId()))
				.and(TransactionJpaSpecification.equalsReference(filter.getReference()))
				.and(TransactionJpaSpecification.equalsTerminalId(filter.getTerminalId()))
				.and(TransactionJpaSpecification.isBetween(filter.getStartDate(), filter.getEndDate()))
		);

		CustomCollection<?> collection = getCollection(specification, filter.getPage(), filter.getSize());
		Response<CustomCollection<?>> response = ResponseImpl.create(true, collection, "successful");

		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> search(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		Acquirer acquirer = getAcquirer(principal);
		String searchTerm = request.getHeader("searchTerm");
		int page = Integer.parseInt(request.getHeader("page"));
		int size = Integer.parseInt(request.getHeader("size"));

		Specification<Transaction> specification = Specification.where(TransactionJpaSpecification.equalsAcquirerId(acquirer.getCbnId())
				.and(
						TransactionJpaSpecification.likeMerchantId(searchTerm)
						.or(TransactionJpaSpecification.likeReference(searchTerm))
						.or(TransactionJpaSpecification.likeTerminalId(searchTerm))
						.or(TransactionJpaSpecification.likeTimeCompleted(searchTerm))
				));

		CustomCollection<?> collection = getCollection(specification, page, size);
		Response<CustomCollection<?>> response = ResponseImpl.create(true, collection, "successful");

		return ResponseEntity.ok(response);
	}


	/**
	 * Gets a collection of transaction objects based on query specification and page information.
	 * @param specification query specification.
	 * @param page page number.
	 * @param size page size.
	 * @return collection of data with paging information.
	 */
	private CustomCollection<Transaction> getCollection(Specification<Transaction> specification, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		if ( pageable.isUnpaged()){
			pageable = PageRequest.of(0,10);
		}

		Page<Transaction> pagedData = transactionJpaService.filter(specification, pageable);
		PageInfo pageInfo = PageInfoImpl.of(pageable, pagedData);

		return CustomCollection.create(pagedData.getContent(), pageInfo);

	}

	private Acquirer getAcquirer(Principal principal){
		String id = principal.getName();
		Specification<Acquirer> specification = Specification.where(AcquirerJpaSpecification.equalsId(id));
		return acquirerService.findOne(specification).orElseThrow();
	}


}
