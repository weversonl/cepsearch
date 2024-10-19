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
@RedisHash(value = "Location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1057320501381714574L;

    @JsonProperty("type")
    private String type;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

}
