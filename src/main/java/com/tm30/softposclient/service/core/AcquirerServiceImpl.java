package com.tm30.softposclient.service.core;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm30.softposclient.model.payload.RequestImpl;
import com.tm30.softposclient.model.payload.Response;
import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.model.dto.AcquirerDto;
import com.tm30.softposclient.model.mapper.AcquirerMapper;
import com.tm30.softposclient.model.payload.ResponseImpl;
import com.tm30.softposclient.service.core.interfaces.AcquirerService;

import com.tm30.softposclient.service.jpa.interfaces.AcquirerJpaService;
import com.tm30.softposclient.service.jpa.specification.AcquirerJpaSpecification;
import com.tm30.softposclient.utils.JsonStringParserUtils;
import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * @author Adebayo.A.Okutubo
 */
@Service
@RequiredArgsConstructor
public class AcquirerServiceImpl implements AcquirerService {

	private final AcquirerJpaService acquirerJpaService;
	private final BCryptPasswordEncoder passwordEncoder;
	private ObjectMapper objectMapper = new ObjectMapper();


	private void create(Acquirer acquirer){
		String encodedPassword = passwordEncoder.encode(acquirer.getPassword());
		acquirer.setPassword(encodedPassword);

		acquirerJpaService.save(acquirer);
	}

	public ResponseEntity<?> create(HttpServletRequest request) throws IOException {
		String adminId = request.getUserPrincipal().getName();
		//TODO: adminId  checks

		String stringBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

		RequestImpl<?> body = JsonStringParserUtils.convertJsonStringToObjectType(stringBody,
				RequestImpl.class);
		String dtoString = objectMapper.writeValueAsString(body.getBody());
		AcquirerDto acquirerDto = objectMapper.readValue(dtoString, AcquirerDto.class);

		AcquirerMapper mapper = AcquirerMapper.INSTANCE;
		Acquirer acquirer = mapper.mapDtoToAcquirer(acquirerDto);
		acquirer.setActive(true);

		create(acquirer);

		Response<?> response = ResponseImpl.create(true, acquirer,"Account created successfully");
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> updatePersonalInfo(HttpServletRequest request) throws IOException {
		String stringBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

		RequestImpl<?> body = JsonStringParserUtils.convertJsonStringToObjectType(stringBody,
				RequestImpl.class);
//		byte[] dtoBytes = objectMapper.writeValueAsBytes(body.getBody());
		String dtoString = objectMapper.writeValueAsString(body.getBody());
		AcquirerDto acquirerDto = objectMapper.readValue(dtoString, AcquirerDto.class);
		Acquirer acquirer = getAcquirerFromPrincipal(request);
		updateAcquirer(acquirerDto, acquirer);
		Response<?> response = ResponseImpl.create(true, "successfully updated");
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> updateProcessors(HttpServletRequest request) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<?> updateConfigurations(HttpServletRequest request) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<?> updateInstitutionBin(HttpServletRequest request) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<?> all(HttpServletRequest request) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<?> one(HttpServletRequest request) throws IOException {
		return null;
	}

	private void updateAcquirer(AcquirerDto acquirerDto, Acquirer acquirer) {
		acquirer.setAddress(acquirerDto.getAddress()== null? acquirer.getAddress() : acquirerDto.getAddress());
		acquirer.setName(acquirerDto.getName()== null || acquirerDto.getName().isEmpty()?
				acquirer.getName() : acquirerDto.getName());
		acquirer.setDescription(acquirerDto.getDescription()== null? acquirer.getDescription() : acquirerDto.getDescription());
		acquirer.setCode(acquirerDto.getCode()== null || acquirerDto.getCode().isEmpty()? acquirer.getCode() : acquirerDto.getCode());
		acquirer.setCbnId(acquirerDto.getCbnId()== null || acquirerDto.getCbnId().isEmpty()? acquirer.getCbnId() : acquirerDto.getCbnId());
		acquirer.setEmail(acquirerDto.getEmail()== null || acquirerDto.getEmail().isEmpty()? acquirer.getEmail() : acquirerDto.getEmail());
		save(acquirer);
	}


	private Acquirer getAcquirerFromPrincipal(HttpServletRequest request) {
		String acquirerId = request.getUserPrincipal().getName();
		Specification<Acquirer> spec = Specification.where(AcquirerJpaSpecification.equalsId(acquirerId));
		Optional<Acquirer> acquirerOptional = acquirerJpaService.findOne(spec);
		return acquirerOptional.orElseThrow();
	}


	public void save(Acquirer acquirer){

		acquirerJpaService.save(acquirer);

	}

	public void update(Acquirer acquirer){
		acquirerJpaService.save(acquirer);
	}

	public Acquirer findByUid(String id){
		Specification<Acquirer>  specification = Specification.where(AcquirerJpaSpecification.equalsId(id));
		return acquirerJpaService.findOne(specification).orElseThrow();
	}


	@Override
	public Acquirer findOne(String id) {
		return null;
	}
}
