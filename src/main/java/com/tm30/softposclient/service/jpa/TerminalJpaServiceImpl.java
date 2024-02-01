package com.tm30.softposclient.service.jpa;


import com.tm30.softposclient.entities.Terminal;
import com.tm30.softposclient.repositories.TerminalRepository;
import com.tm30.softposclient.service.jpa.interfaces.TerminalJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TerminalJpaServiceImpl implements TerminalJpaService {
	private final TerminalRepository repository;
	@Override
	public Optional<Terminal> findOne(Specification<Terminal> specification) {
		return repository.findOne(specification);
	}

	@Override
	public Page<Terminal> findAll(Specification<Terminal> specification, Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	@Override
	public List<Terminal> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Terminal entity) {
		repository.save(entity);
	}
}
