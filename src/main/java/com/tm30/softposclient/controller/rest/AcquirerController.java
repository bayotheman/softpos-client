package com.tm30.softposclient.controller.rest;

import com.tm30.softposclient.service.core.interfaces.AcquirerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/acquirer")
public class AcquirerController {

	private final AcquirerService acquirerService;


	@PostMapping("/create-acquirer-account")
	public ResponseEntity<?> register(HttpServletRequest request) throws IOException {
		return acquirerService.create(request);
	}

	@PostMapping("/update-personal-info")
	public ResponseEntity<?> updatePersonalInfo(HttpServletRequest request) throws IOException {
		return acquirerService.updatePersonalInfo(request);
	}

	@PostMapping("/update-processors")
	public ResponseEntity<?> updateProcessors(HttpServletRequest request) throws IOException {
		return acquirerService.updateProcessors(request);
	}

	@PostMapping("/update-institution-bin")
	public ResponseEntity<?> updateInstitutionBin(HttpServletRequest request) throws IOException {
		return acquirerService.updateInstitutionBin(request);
	}

}
