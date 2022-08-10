package com.sphereon.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * A JSON-LD Verifiable Credential without a proof.
 */
@Schema(description = "A JSON-LD Verifiable Credential without a proof.")
@Validated

public class Credential implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("issuer")
    @JsonDeserialize(using = VdxIssuerDeserializer.class)
    private Issuer issuer = null;


    public Credential id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The ID of the credential.
     *
     * @return id
     **/
    @Schema(description = "The ID of the credential.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Credential issuer(Issuer issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * Get issuer
     *
     * @return issuer
     **/
    @Schema(description = "")

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Credential that = (Credential) o;
        return id.equals(that.id) && issuer.equals(that.issuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issuer);
    }

    @Override
    public String toString() {
        return "Credential{" +
          "id='" + id + '\'' +
          ", issuer=" + issuer +
          '}';
    }
}
