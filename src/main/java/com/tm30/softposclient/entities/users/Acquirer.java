package com.tm30.softposclient.entities.users;


import com.tm30.softposclient.entities.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.*;

@Getter
@Setter
@Entity
public class Acquirer extends BaseUser{
	private String code;
	private String cbnId;
	private String description;

	@ElementCollection
	private Map<String, InstitutionBin> institutionBinMap = new HashMap<>();

	@OneToMany(mappedBy= "acquirer",cascade = CascadeType.ALL)
	private List<Merchant> merchants = new ArrayList<>();

	@OneToMany
	@Reference
	private List<SubAccount> subAccounts = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private Map<String, AgentManagerPlatform> agentManagers = new HashMap<>();

//	@JsonBackReference
	@OneToMany(mappedBy= "acquirer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Map<String, ProcessorConfig> processorConfigList = new HashMap<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Map<String, RoutingConfiguration> configurationMap= new HashMap<>();

	@ElementCollection
	private Set<Hsm> hsmSet = new HashSet<>();


	public Acquirer(){
		setRole(Role.ACQUIRER);
	}

	public void addMerchant(Merchant merchant){
		merchants.add(merchant);
	}

	public void addProcessorConfig(String factoryId, ProcessorConfig processor){
		processorConfigList.put(factoryId, processor);
	}

	public String getProcessorByBin(String code){
		return processorConfigList.get(code).getProcessor().getFactoryId();
	}


	public String getProcessorFactoryIdByBin(String code){
		return institutionBinMap.get(code).getProcessorFactoryId();
	}

	public Set<String> getProcessorSet(){
		return processorConfigList.keySet();
	}

	public void addAgentManagerPlatform(AgentManagerPlatform platform){
		agentManagers.put(platform.getId(), platform);
	}

	@Override
	public String toString() {
		return "Acquirer{" +
				"code='" + code + '\'' +
				", cbnId='" + cbnId + '\'' +
				", description='" + description + '\'' +
				", institutionBinMap=" + institutionBinMap +
				", merchants=" + merchants +
				", subAccounts=" + subAccounts +
				", agentManagers=" + agentManagers +
				", processorConfigList=" + processorConfigList +
				", configurationMap=" + configurationMap +
				", hsmSet=" + hsmSet +
				'}';
	}
}
