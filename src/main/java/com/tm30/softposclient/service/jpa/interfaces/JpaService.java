package com.tm30.softposclient.service.jpa.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Interface that defines common functions for Jpa service classes.
 * @author Adebayo.A.Okutubo
 * @param <T> specification domain parameter
 */
public interface JpaService<T> {

	/**
	 * Gets entity T based on the query specification specified.
	 * @param specification query specification.
	 * @return optional object that may contain the resulting T object or not.
	 */
	Optional<T> findOne(Specification<T> specification);
	Page<T> findAll(Specification<T> specification, Pageable pageable);
	 List<T> findAll();

	default void save(T entity){}
}
