package com.tm30.softposclient.service.jpa;


import com.tm30.softposclient.entities.Processor;
import com.tm30.softposclient.repositories.ProcessorRepository;
import com.tm30.softposclient.service.jpa.interfaces.ProcessorJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Qualifier("processorJpaService")
public class ProcessorJpaServiceImpl implements ProcessorJpaService {
	public final ProcessorRepository repository;

	@Override
	public Optional<Processor> findOne(Specification<Processor> specification){
		return repository.findOne(specification);
	}

	@Override
	public Page<Processor> findAll(Specification<Processor> specification, Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	@Override
	public List<Processor> findAll() {
		return repository.findAll();
	}


	@Override
	public void save(Processor entity) {
		repository.save(entity);
	}
}
