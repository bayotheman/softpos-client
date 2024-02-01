package com.tm30.softposclient.service.core;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.entities.Terminal;
import com.tm30.softposclient.service.core.interfaces.TerminalService;
import com.tm30.softposclient.service.jpa.interfaces.TerminalJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Adebayo.A.Okutubo
 */
@Service
@RequiredArgsConstructor
public class TerminalServiceImpl implements TerminalService {

	private final TerminalJpaService terminalJpaService;
	@Override
	public void save(Terminal domain) {
		terminalJpaService.save(domain);
	}

	@Override
	public Terminal findByMerchantAndTid(Merchant merchant, String terminalId) {
		return null;
	}

	public Terminal findById(String terminalId) {
		return null;
	}


}
