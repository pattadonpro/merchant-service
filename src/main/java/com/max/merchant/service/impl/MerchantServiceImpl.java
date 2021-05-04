package com.max.merchant.service.impl;

import com.max.merchant.domain.Merchant;

import com.max.merchant.domain.dto.MerchantDTO;
import com.max.merchant.exception.ResourceNotFoundException;
import com.max.merchant.mapper.MerchantMapper;
import com.max.merchant.repository.MerchantRepository;
import com.max.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    private final MerchantMapper merchantMapper;

    public MerchantDTO save(MerchantDTO merchantDTO) {
        Merchant merchant = merchantMapper.toEntity(merchantDTO);
        Merchant savedMerchant = merchantRepository.save(merchant);
        return merchantMapper.toDto(savedMerchant);
    }

    public List<MerchantDTO> findAll() {
        List<Merchant> merchants = merchantRepository.findAll();
        return merchantMapper.toDto(merchants);
    }

    public MerchantDTO findById(Integer id) {
        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merchant not found"));
        return merchantMapper.toDto(merchant);
    }
}
