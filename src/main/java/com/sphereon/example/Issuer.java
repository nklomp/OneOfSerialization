package com.sphereon.example;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Issuer
 */
@JsonSubTypes({@Type(IssuerIdObject.class), @Type(IssuerString.class)})
public interface Issuer {

}
