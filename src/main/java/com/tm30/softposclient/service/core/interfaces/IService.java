package com.tm30.softposclient.service.core.interfaces;

/**
 * @author Adebayo.A.Okutubo
 * @param <T> domain of application.
 */

public interface IService<T> {
//	T findOne(Specification<T> specification);
	void save(T domain);
}
