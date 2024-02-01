package com.tm30.softposclient.service.core;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.model.dto.MerchantDto;
import com.tm30.softposclient.model.mapper.MerchantMapper;
import com.tm30.softposclient.model.payload.Response;
import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.model.payload.RequestImpl;
import com.tm30.softposclient.model.payload.ResponseImpl;
import com.tm30.softposclient.service.core.interfaces.MerchantService;
import com.tm30.softposclient.service.jpa.interfaces.AcquirerJpaService;
import com.tm30.softposclient.service.jpa.interfaces.MerchantJpaService;
import com.tm30.softposclient.service.jpa.specification.AcquirerJpaSpecification;
import com.tm30.softposclient.service.jpa.specification.MerchantJpaSpecification;
import com.tm30.softposclient.utils.JsonStringParserUtils;
import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Optional;

/**
 * @author Adebayo.A.Okutubo
 */
@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {
	private final MerchantJpaService service;
	private final AcquirerJpaService acquirerJpaService;
	private final MerchantMapper mapper = MerchantMapper.INSTANCE;


	public Merchant findByAcquirerAndId(Acquirer acquirer, String merchantId){
		Specification<Merchant> specification = Specification.where(MerchantJpaSpecification.equalsAcquirer(acquirer)
				.and(MerchantJpaSpecification.equalsId(merchantId)));

		Optional<Merchant> optionalMerchant = service.findOne(specification);
		return optionalMerchant.orElseThrow();
	}

	@Override
	public Merchant findById(String merchantId) {
		Specification<Merchant> specification = Specification.where(MerchantJpaSpecification.equalsId(merchantId));

		Optional<Merchant> optionalMerchant = service.findOne(specification);
		return optionalMerchant.orElseThrow();
	}

	public void save(Merchant merchant){
		service.save(merchant);
	}


	@Override
	public ResponseEntity<?> create(HttpServletRequest request) throws IOException {
		Principal principal = request.getUserPrincipal();
		Acquirer acquirer = getAcquirerFromPrincipal(principal);
		String stringBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
		RequestImpl<MerchantDto> body = JsonStringParserUtils.convertJsonStringToObjectType(stringBody,
				RequestImpl.class);
		MerchantDto merchantDto = body.getBody();
		Merchant merchant = mapper.mapDtoToMerchant(merchantDto);
		merchant.setAcquirer(acquirer);
		acquirer.addMerchant(merchant);
//		acquirerJpaService.save(acquirer);
		service.save(merchant);

		Response<?> response = ResponseImpl.create(true, "Merchant successfully added");
		return ResponseEntity.ok(response);
	}

	private Acquirer getAcquirerFromPrincipal(Principal principal) {
		String acquirerId = principal.getName();
		Specification<Acquirer> spec = Specification.where(AcquirerJpaSpecification.equalsId(acquirerId));
		Optional<Acquirer> acquirerOptional = acquirerJpaService.findOne(spec);
		return acquirerOptional.orElseThrow();
	}


	@Override
	public ResponseEntity<?> updatePersonalInfo(HttpServletRequest request) {
		return null;
	}

	@Override
	public ResponseEntity<?> updateTerminal(HttpServletRequest request) {
		return null;
	}


}
