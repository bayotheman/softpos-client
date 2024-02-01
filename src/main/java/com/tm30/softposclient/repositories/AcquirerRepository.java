package com.tm30.softposclient.repositories;

import com.tm30.softposclient.entities.users.Acquirer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AcquirerRepository extends JpaRepository<Acquirer, String>, JpaSpecificationExecutor<Acquirer> {



	Optional<Acquirer> findByEmail(String email);

}
