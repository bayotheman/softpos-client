package com.tm30.softposclient.service.jpa;



import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.repositories.MerchantRepository;
import com.tm30.softposclient.service.jpa.interfaces.MerchantJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantJpaServiceImpl implements MerchantJpaService {

	private final MerchantRepository repository;

	public void save(Merchant merchant){
		repository.save(merchant);
	}

	@Override
	public Optional<Merchant> findOne(Specification<Merchant> specification){
		return repository.findOne(specification);
	}

	@Override
	public Page<Merchant> findAll(Specification<Merchant> specification, Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	@Override
	public List<Merchant> findAll() {
		return repository.findAll();
	}


}
