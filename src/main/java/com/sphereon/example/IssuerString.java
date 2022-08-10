package com.sphereon.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * IssuerString
 */
@Validated
public class IssuerString implements Serializable, Issuer {

    private static final long serialVersionUID = 1L;

    // This annotation is enough to ensure we do not have to create a custom serializer. It will result in issuer: "<value from this class>"
    @JsonValue
    private String value = null;

    @JsonCreator
    public IssuerString(String value) {
        this.value = value;
    }

    public IssuerString() {
    }

    public IssuerString value(String value) {
        this.value = value;
        return this;
    }

    /**
     * The ID of the issuer.
     *
     * @return id
     **/
    @Schema(description = "The ID of the issuer.")

    public String getValue() {
        return value;
    }

    public void setValue(String id) {
        this.value = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IssuerString that = (IssuerString) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
