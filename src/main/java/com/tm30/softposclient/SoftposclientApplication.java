package com.tm30.softposclient;

import com.tm30.softposclient.entities.*;
import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.entities.users.AgentManagerPlatform;
import com.tm30.softposclient.service.jpa.interfaces.AcquirerJpaService;
import com.tm30.softposclient.service.jpa.interfaces.MerchantJpaService;
import com.tm30.softposclient.service.jpa.interfaces.ProcessorJpaService;
import com.tm30.softposclient.service.jpa.interfaces.TerminalJpaService;
import com.tm30.softposclient.utils.CryptographyUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SoftposclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftposclientApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner initialize(AcquirerJpaService acquirerJpaService,
	                             ProcessorJpaService processorJpaService,
	                             MerchantJpaService merchantJpaService,
	                             TerminalJpaService terminalJpaService) throws Exception {
		List<Processor> processors = processorJpaService.findAll();
		if(processors == null || processors.isEmpty()) {
			Processor upsl = new Processor();
			upsl.setEnabled(true);
			upsl.setFactoryId("UPSL");
			upsl.setDescription("Unified Payment's Processor");
			upsl.setName("UPSL by Unified Payments");
			processorJpaService.save(upsl);

			//		}

			ProcessorConfig processorConfig = new ProcessorConfig();
			processorConfig.setActive(true);
			processorConfig.setProcessor(upsl);
			processorConfig.setName("UPSL Processor");

			processorConfig.setHsmTranslation(false);
			processorConfig.setInstitutionBin("111129");
			processorConfig.setTerminalId("28000359");
			processorConfig.setMerchantId("2800LA000000040");
			processorConfig.setPriority(ProcessorPriority.PRIMARY);

			Acquirer acquirer = new Acquirer();
			acquirer.setActive(true);
			acquirer.setName("Unified Payment");
			acquirer.setEmail("info@up.com");
			acquirer.setCbnId("111129");
			acquirer.setRole(Role.ACQUIRER);
			acquirer.setCode("111129");
			acquirer.setAddress("1, Adeola Odeku Street");
			acquirer.addProcessorConfig(processorConfig.getInstitutionBin(), processorConfig);


			AgentManagerPlatform platform = new AgentManagerPlatform();
			platform.setName("UP Agent Manager ");
			platform.setAcquirer(acquirer);
			platform.setActive(true);
			platform.setAccessKey(RandomStringUtils.randomAlphanumeric(64));
			acquirer.addAgentManagerPlatform(platform);


			processorConfig.setAcquirer(acquirer);
			acquirerJpaService.save(acquirer);


			Merchant merchant = new Merchant();
			merchant.setId("01HCA854D9DWXMDJAKZ6FN250P");
			System.out.println("Merchant Id: " + merchant.getId());
			merchant.setAcquirer(acquirer);
			merchant.setName("Paymybills Nig ltd");
			merchant.setCountryCode("566");
			merchant.setBvn("1001345510");
			merchant.setType("Payment Service");
			merchant.setEmail("info@pmb.ng");
			merchant.setPhone("08000000012");
			merchant.setActive(true);

			merchantJpaService.save(merchant);


			Terminal terminal = new Terminal();
			terminal.setMerchant(merchant);
			terminal.setImei("");
			terminal.setNfcId("");
			terminal.setDeviceId("d7dda3d75eab4d0f");
			terminal.setOsVersion("");
			terminal.setAppVersion("");
			terminal.setActive(true);
//			String masterKey = RandomStringUtils.randomAlphanumeric(32);
			String masterKey = "3CDDE1CC6FDD225C9A8BC3EB065509A6";
			String encryptedMasterKey = CryptographyUtil.encrypt(masterKey,CryptographyUtil.CTMK);
			System.out.println("\n MasterKey Plain Text: " + masterKey);
			System.out.println("MasterKey Cipher: " + encryptedMasterKey);
			terminal.setMasterKey(encryptedMasterKey);
			terminal.setSessionKey(encryptedMasterKey);
			terminal.setPinKey(encryptedMasterKey);
//			terminal.setMasterKey("3CDDE1CC6FDD225C9A8BC3EB065509A6");
//			terminal.setSessionKey("3CDDE1CC6FDD225C9A8BC3EB065509A6");
//			terminal.setPinKey("3CDDE1CC6FDD225C9A8BC3EB065509A6");


			String decryptedMasterKey = CryptographyUtil.decrypt(encryptedMasterKey, CryptographyUtil.CTMK);
			System.out.println("MasterKey Plain Text: " + decryptedMasterKey);

			terminalJpaService.save(terminal);

			System.out.println("Acquirer: " + acquirer.getCbnId());

		}


		return args ->System.out.println("  "  );
	}

}
