package com.tm30.softposclient.service.jpa;



import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.repositories.AcquirerRepository;
import com.tm30.softposclient.service.jpa.interfaces.AcquirerJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcquirerJpaServiceImpl implements AcquirerJpaService {

	private final AcquirerRepository repository;

	public void save(Acquirer acquirer){
		repository.save(acquirer);
	}

	public Optional<Acquirer> findByUid(String id){
		return repository.findById(id);
	}


	@Override
	public Optional<Acquirer> findOne(Specification<Acquirer> spec){
		return repository.findOne(spec);
	}

	/**
	 * Gets a list of paginated acquirers based on query specification specified.
	 * @param spec query specification.
	 * @param pageable pagination specification
	 * @return a list of acquirers.
	 */
	public Page<Acquirer> findAll(Specification<Acquirer> spec, Pageable pageable){
		return repository.findAll(spec, pageable);
	}

	@Override
	public List<Acquirer> findAll() {
		return repository.findAll();
	}


}
