package com.tm30.softposclient.service.core.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface TransactionService {
	ResponseEntity<?> search(HttpServletRequest request);
	ResponseEntity<?> filter(HttpServletRequest request) throws IOException;
}
