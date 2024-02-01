package com.tm30.softposclient.configuration.auditing;

import com.tm30.softposclient.entities.users.BaseUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
	@NotNull
	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> optionalUser = Optional.ofNullable(((BaseUser) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal())
				.getId());
//		if(optionalUser.isEmpty()){
//			return null;
//		}
		return optionalUser;
	}
}
