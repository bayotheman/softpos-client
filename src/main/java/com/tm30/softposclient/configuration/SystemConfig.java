//package com.up.softposclient.configuration;
//
//
//import com.up.softposclient.entities.Processor;
//import com.up.softposclient.entities.ProcessorConfig;
//import com.up.softposclient.entities.ProcessorPriority;
//import com.up.softposclient.entities.Role;
//import com.up.softposclient.entities.users.Acquirer;
//import com.up.softposclient.service.jpa.interfaces.AcquirerJpaService;
//import com.up.softposclient.service.jpa.interfaces.ProcessorJpaService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class SystemConfig {
//
//
//	private AcquirerJpaService acquirerJpaService ;
//
//
//	private ProcessorJpaService processorJpaService;
//
//	public void initialize(){
//		Processor upsl = new Processor();
//		upsl.setEnabled(true);
//		upsl.setFactoryId("UPSL");
//		upsl.setDescription("Unified Payment's Processor");
//		upsl.setName("UPSL by Unified Payments");
//		processorJpaService.save(upsl);
//
//		ProcessorConfig processorConfig = new ProcessorConfig();
//		processorConfig.setActive(true);
//		processorConfig.setProcessor(upsl);
//		processorConfig.setName("UPSL Processor");
//
//		processorConfig.setHsmTranslation(false);
//		processorConfig.setInstitutionBin("111129");
//		processorConfig.setTerminalId("28000359");
//		processorConfig.setMerchantId("2800LA000000040");
//		processorConfig.setPriority(ProcessorPriority.PRIMARY);
//
//
//		Acquirer acquirer = new Acquirer();
//		acquirer.setEmail("info@up.com");
//		acquirer.setCbnId("111129");
//		acquirer.setRole(Role.ACQUIRER);
//		acquirer.setCode("111129");
//		acquirer.setAddress("1, Adeola Odeku Street");
//		acquirer.addProcessorConfig(processorConfig.getInstitutionBin(), processorConfig);
//
//		processorConfig.setAcquirer(acquirer);
//
//		acquirerJpaService.save(acquirer);
//	}
//}
