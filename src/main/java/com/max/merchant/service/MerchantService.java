package com.max.merchant.service;

import com.max.merchant.domain.dto.MerchantDTO;

import java.util.List;

public interface MerchantService {

    MerchantDTO saveMerchant(MerchantDTO merchantDTO);

    List<MerchantDTO> findAllMerchant();

    MerchantDTO findMerchantById(Integer id);

}
