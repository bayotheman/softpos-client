package com.tm30.softposclient.model.mapper;


import com.tm30.softposclient.entities.Merchant;
import com.tm30.softposclient.model.dto.MerchantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantMapper {

	MerchantMapper INSTANCE = Mappers.getMapper(MerchantMapper.class);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "terminals", ignore = true)
	@Mapping(target = "phone", ignore = true)
	@Mapping(target = "email", ignore = true)
	@Mapping(target = "bvn", ignore = true)
	@Mapping(target = "acquirer", ignore = true)
	Merchant mapDtoToMerchant(MerchantDto dto);

}
