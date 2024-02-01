package com.tm30.softposclient.repositories;

import com.tm30.softposclient.entities.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TerminalRepository extends JpaRepository<Terminal, String>, JpaSpecificationExecutor<Terminal> {

}
