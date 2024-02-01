package com.tm30.softposclient.repositories;

import com.tm30.softposclient.entities.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProcessorRepository extends JpaRepository<Processor, String>, JpaSpecificationExecutor<Processor> {
}
