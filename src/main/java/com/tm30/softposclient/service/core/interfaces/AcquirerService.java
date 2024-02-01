package com.tm30.softposclient.service.core.interfaces;

import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;

public interface AcquirerService extends IService<Acquirer> {
	Acquirer findOne(String id);
	Acquirer findByUid(String uid);
	ResponseEntity<?> create(HttpServletRequest request) throws IOException;
	ResponseEntity<?> updatePersonalInfo(HttpServletRequest request) throws IOException;
	ResponseEntity<?> updateProcessors(HttpServletRequest request) throws IOException;
	ResponseEntity<?> updateConfigurations(HttpServletRequest request) throws IOException;
	ResponseEntity<?> updateInstitutionBin(HttpServletRequest request) throws IOException;

	ResponseEntity<?> all(HttpServletRequest request) throws IOException;
	ResponseEntity<?> one(HttpServletRequest request) throws IOException;
//	ResponseEntity<?> updateMerchants(HttpServletRequest request) throws IOException;
	default ResponseEntity<?> updateHsms(HttpServletRequest request) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Operation not supported");
	};
}
