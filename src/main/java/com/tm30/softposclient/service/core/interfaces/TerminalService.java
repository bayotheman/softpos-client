package com.tm30.softposclient.service.core.interfaces;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.entities.Terminal;

public interface TerminalService extends IService<Terminal>{

	Terminal findByMerchantAndTid(Merchant merchant, String terminalId);
	Terminal findById(String terminalId);


}
