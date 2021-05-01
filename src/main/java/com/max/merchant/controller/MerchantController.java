package com.max.merchant.controller;

import com.max.merchant.domain.dto.MerchantDTO;
import com.max.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @GetMapping
    public ResponseEntity<List<MerchantDTO>> getAllMerchant() {
        List<MerchantDTO> result = merchantService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchantDTO> getMerchantById(@PathVariable Integer id) {
        MerchantDTO result = merchantService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<MerchantDTO> createMerchant(@Valid @RequestBody MerchantDTO merchantDTO) throws URISyntaxException {
        MerchantDTO result = merchantService.save(merchantDTO);
        return ResponseEntity.created(new URI("/api/merchants")).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MerchantDTO> updateMerchant(@Valid @RequestBody MerchantDTO merchantDTO, @PathVariable Integer id) {
        merchantDTO.setId(id);
        MerchantDTO result = merchantService.save(merchantDTO);
        return ResponseEntity.ok(result);
    }
}
