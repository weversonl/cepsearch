package com.cepsearch.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "PostalCode")
public class PostalCodeResponse implements Serializable {

    private static final long serialVersionUID = 6583635153965709585L;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("location")
    private Location location;

}
