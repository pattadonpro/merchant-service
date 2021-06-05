package com.max.merchant.controller;

import com.max.merchant.domain.dto.MerchantDTO;
import com.max.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    @PreAuthorize("#oauth2.hasScope('merchant.merchant.r')")
    @GetMapping
    public ResponseEntity<List<MerchantDTO>> getAllMerchant() {
        List<MerchantDTO> result = merchantService.findAll();
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("#oauth2.hasScope('merchant.merchant.r')")
    @GetMapping("/{id}")
    public ResponseEntity<MerchantDTO> getMerchantById(@PathVariable Integer id) {
        MerchantDTO result = merchantService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("#oauth2.hasScope('merchant.merchant.w')")
    @PostMapping
    public ResponseEntity<MerchantDTO> createMerchant(@Valid @RequestBody MerchantDTO merchantDTO) throws URISyntaxException {
        MerchantDTO result = merchantService.save(merchantDTO);
        return ResponseEntity.created(new URI("/api/merchants")).body(result);
    }

    @PreAuthorize("#oauth2.hasScope('merchant.merchant.w')")
    @PutMapping("/{id}")
    public ResponseEntity<MerchantDTO> updateMerchant(@Valid @RequestBody MerchantDTO merchantDTO, @PathVariable Integer id) {
        merchantDTO.setId(id);
        MerchantDTO result = merchantService.save(merchantDTO);
        return ResponseEntity.ok(result);
    }
}
