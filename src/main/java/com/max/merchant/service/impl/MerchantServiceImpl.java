package com.max.merchant.service.impl;

import com.max.merchant.domain.Merchant;

import com.max.merchant.domain.dto.MerchantDTO;
import com.max.merchant.mapper.MerchantMapper;
import com.max.merchant.repository.MerchantRepository;
import com.max.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private MerchantMapper merchantMapper;

    public MerchantDTO saveMerchant(MerchantDTO merchantDTO) {
        Merchant merchant = merchantMapper.toEntity(merchantDTO);
        Merchant savedMerchant = merchantRepository.save(merchant);
        return merchantMapper.toDto(savedMerchant);
    }

    public List<MerchantDTO> findAllMerchant() {
        List<Merchant> merchants = merchantRepository.findAll();
        return merchantMapper.toDto(merchants);
    }

    public MerchantDTO findMerchantById(Integer id) {
        Merchant merchant = merchantRepository.findById(id).get();
        return merchantMapper.toDto(merchant);
    }
}
