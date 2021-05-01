package com.max.merchant.service;

import com.max.merchant.domain.dto.MerchantDTO;

import java.util.List;

public interface MerchantService {

    MerchantDTO save(MerchantDTO merchantDTO);

    List<MerchantDTO> findAll();

    MerchantDTO findById(Integer id);

}
