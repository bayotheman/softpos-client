package com.tm30.softposclient.service.core;


import com.tm30.softposclient.entities.Processor;
import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.service.core.interfaces.ProcessorEntityService;
import com.tm30.softposclient.service.jpa.interfaces.ProcessorJpaService;
import com.tm30.softposclient.service.jpa.specification.ProcessorJpaSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcessorEntityServiceImpl implements ProcessorEntityService {

    private final ProcessorJpaService service;

    @Override
    public void save(Processor domain) {
    }

    @Override
    public Processor findByAcquirerAndInstitutionBin(Acquirer acquirer, String institutionBin) {
        Specification<Processor> specification = Specification.where(ProcessorJpaSpecification.equalsAcquirer(acquirer)
                .and(ProcessorJpaSpecification.equalsInstitutionBin(institutionBin)));

        Optional<Processor> optionalProcessor = service.findOne(specification);
        return optionalProcessor.orElseThrow();
    }

    @Override
    public Processor findByInstitutionBin(String bin) {
        Specification<Processor> specification = Specification.where(ProcessorJpaSpecification.equalsInstitutionBin(bin));
        Optional<Processor> optionalProcessor = service.findOne(specification);
        return optionalProcessor.orElseThrow();
    }
}
