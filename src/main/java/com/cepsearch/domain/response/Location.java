package com.cepsearch.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash(value = "Location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1057320501381714574L;

    @JsonProperty("type")
    private String type;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

}
