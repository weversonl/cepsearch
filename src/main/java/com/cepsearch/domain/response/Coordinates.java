package com.cepsearch.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Coordinates")
public class Coordinates implements Serializable {

    private static final long serialVersionUID = 7901285851415427997L;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("latitude")
    private String latitude;

}
