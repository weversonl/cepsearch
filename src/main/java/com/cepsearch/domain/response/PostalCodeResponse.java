package com.cepsearch.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

import static com.cepsearch.util.redis.TimeToLiveRedis.TWENTY_FOUR_HRS;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "PostalCode", timeToLive = TWENTY_FOUR_HRS)
public class PostalCodeResponse implements Serializable {

    private static final long serialVersionUID = 6583635153965709585L;

    @Id
    @Indexed
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
