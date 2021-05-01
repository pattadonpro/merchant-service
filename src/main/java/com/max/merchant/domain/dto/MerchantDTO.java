package com.max.merchant.domain.dto;

import com.max.merchant.config.Constants;
import com.max.merchant.domain.enumeration.Category;
import com.max.merchant.validation.ValueOfEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class MerchantDTO {
    private Integer id;

    @NotBlank
    private String name;

    @ValueOfEnum(enumClass = Category.class)
    private String category;

    @Pattern(regexp = Constants.MOBILE_NUMBER_REGEX)
    private String mobileNumber;

    @Email
    private String email;

    @NotBlank
    private String logoUrl;

    private String description;
}
