package com.tm30.softposclient.model.mapper;

import com.tm30.softposclient.entities.users.Acquirer;
import com.tm30.softposclient.model.dto.AcquirerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AcquirerMapper {
	AcquirerMapper INSTANCE = Mappers.getMapper(AcquirerMapper.class);

	@Mapping(target = "subAccounts", ignore = true)
	@Mapping(target = "role", ignore = true)
	@Mapping(target = "previousPasswords", ignore = true)
//	@Mapping(target = "modifiedBy", ignore = true)
//	@Mapping(target = "defaultPassword", source = "password")
//	@Mapping(target = "dateModified", ignore = true)
//	@Mapping(target = "dateCreated", ignore = true)
//	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "password", ignore = true)
	@Mapping(target = "merchants", ignore = true)
	@Mapping(target = "institutionBinMap", ignore = true)
	@Mapping(target = "hsmSet",ignore = true)
	@Mapping(target = "configurationMap", ignore = true)
	@Mapping(target = "cbnId", source = "code")
	Acquirer mapDtoToAcquirer(AcquirerDto dto);



}
