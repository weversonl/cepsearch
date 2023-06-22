package com.cepsearch.domain.dto;

import com.cepsearch.annotations.PostalCodeValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostalCodeDTO implements Serializable {

    private static final long serialVersionUID = -5353127452621581753L;

    @PostalCodeValidation
    private String postalCode;

}
