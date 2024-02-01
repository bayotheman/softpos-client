package com.tm30.softposclient.service.core.interfaces;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface MerchantService extends IService<Merchant>{

	Merchant findByAcquirerAndId(Acquirer acquirer, String merchantId);
	Merchant findById(String merchantId);
	void save(Merchant merchant);


	ResponseEntity<?> create(HttpServletRequest request) throws IOException;
	ResponseEntity<?> updatePersonalInfo(HttpServletRequest request);
	ResponseEntity<?> updateTerminal(HttpServletRequest request);

}
