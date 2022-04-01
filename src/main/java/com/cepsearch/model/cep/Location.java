package com.cepsearch.model.cep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

    @JsonProperty("type")
    private String type;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

}
