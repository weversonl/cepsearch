package com.cepsearch.dto.request;

import com.cepsearch.service.validators.ValidPostalCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.cepsearch.utils.statics.ValidationMessages.INVALID_CEP;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostalCodeRequest implements Serializable {

    private static final long serialVersionUID = -5353127452621581753L;

    @ValidPostalCode(message = INVALID_CEP)
    private String postalCode;

}
