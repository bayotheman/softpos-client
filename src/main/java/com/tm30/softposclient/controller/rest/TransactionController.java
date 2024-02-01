package com.tm30.softposclient.controller.rest;

import com.tm30.softposclient.service.core.TransactionServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionServiceImpl transactionServiceImpl;

	@GetMapping("/filter")
	public ResponseEntity<?> filter(HttpServletRequest request) throws IOException {
		return transactionServiceImpl.filter(request);
	}

//	@GetMapping("/filter")
//	public ResponseEntity<?> filter(Principal principal, @RequestHeader FilterRequest request){
//		return transactionServiceImpl.filter(principal, request);
//	}

	@GetMapping("/search")
	public ResponseEntity<?> search( HttpServletRequest request){
		return transactionServiceImpl.search(request);
	}

}
