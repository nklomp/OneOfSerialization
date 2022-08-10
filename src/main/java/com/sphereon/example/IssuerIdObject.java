package com.sphereon.example;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * IssuerIdObject
 */
@Validated
public class IssuerIdObject implements Serializable, Issuer {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id = null;

    /**
     * When an issuer is an object the ID is required, but it can have more properties. Use JsonAnyGetter/Setter to support it
     */
    private Map<String, Object> properties;

    public IssuerIdObject id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The ID of the issuer.
     *
     * @return id
     **/
    @Schema(description = "The ID of the issuer.")

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @JsonAnySetter
    public void addProperty(String propertyKey, Object value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(propertyKey, value);
    }


    public Object getProperty(String propertyKey) {
        if (this.properties == null) {
            return null;
        }
        return this.properties.get(propertyKey);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IssuerIdObject that = (IssuerIdObject) o;
        return id.equals(that.id) && Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, properties);
    }

    @Override
    public String toString() {
        return "{" +
          "id='" + id + '\'' +
          ", properties=" + properties +
          '}';
    }
}
