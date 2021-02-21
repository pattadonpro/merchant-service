package com.max.merchant.mapper;

import com.max.merchant.domain.Merchant;
import com.max.merchant.domain.dto.MerchantDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper extends EntityMapper<MerchantDTO, Merchant>{
}
