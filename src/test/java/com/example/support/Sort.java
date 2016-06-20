package com.example.support;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "direction",
        "property",
        "ascending"
})
public class Sort {

    @JsonProperty("direction")
    private String direction;
    @JsonProperty("property")
    private String property;
    @JsonProperty("ascending")
    private boolean ascending;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The direction
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction The direction
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return The property
     */
    @JsonProperty("property")
    public String getProperty() {
        return property;
    }

    /**
     * @param property The property
     */
    @JsonProperty("property")
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return The ascending
     */
    @JsonProperty("ascending")
    public boolean isAscending() {
        return ascending;
    }

    /**
     * @param ascending The ascending
     */
    @JsonProperty("ascending")
    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}