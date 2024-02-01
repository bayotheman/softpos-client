package com.tm30.softposclient.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * A utility class for getting spring boot application context to retrieve registered application beans.
 * @author Adebayo.A.Okutubo "adebayo@tm30.dev"
 */
@Component
public final class SpringContext implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;


	public static <T> T getBean(Class<T> beanClass){
		return CONTEXT.getBean(beanClass);
	}

	public static ApplicationContext getContext(){
		return CONTEXT;
	}

	@Override
	public void setApplicationContext( ApplicationContext context) throws BeansException {
		SpringContext.CONTEXT = context;
	}
}
