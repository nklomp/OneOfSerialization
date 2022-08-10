package com.sphereon.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerializationTest {

    // The issuer Object with an id value. Note it has an additional property which is allowed according the spec
    public static final String ID_OBJECT_JSON = "{\"id\":\"id-object-example\",\"issuer\":{\"id\":\"test-issuer-id-object\",\"more\":\"example\"}}";
    // The issuer as a string
    public static final String STRING_JSON = "{\"id\":\"string-example\",\"issuer\":\"test-issuer-string\"}";
    private final ObjectMapper mapper;


    public SerializationTest() {
        this.mapper = new ObjectMapper().findAndRegisterModules();

        /*
         * Register the custom deserializer for the Issuer class.
         * We don't need it as we are in full control of the POJOs, where we use an annotation. Just provided as an example
         *
         * var simpleModule = new SimpleModule();
         *         simpleModule.addDeserializer(Issuer.class, new VdxIssuerDeserializer());
         *         mapper.registerModule(simpleModule);
         */

        /*
         * Not needed, just provided as an example in case we need more complex serialization
         * simpleModule.addSerializer(Issuer.class, new VdxIssuerSerializer());
         */
    }

    @Test
    public void testSerializationAndDeserialization() throws IOException {

        final var stringIssuer = new Credential().id("string-example").issuer(new IssuerString("test-issuer-string"));
        Assertions.assertEquals(STRING_JSON, mapper.writeValueAsString(stringIssuer));
        final var stringIssuerDeserialized = mapper.readValue(STRING_JSON, Credential.class);
        Assertions.assertEquals(stringIssuer, stringIssuerDeserialized);

        final var issuerIdObject = new IssuerIdObject().id("test-issuer-id-object");
        issuerIdObject.addProperty("more", "example");

        final var objectIdIssuer = new Credential().id("id-object-example").issuer(issuerIdObject);
        Assertions.assertEquals(ID_OBJECT_JSON, mapper.writeValueAsString(objectIdIssuer));
        final var objectIdIssuerDeserialized = mapper.readValue(ID_OBJECT_JSON, Credential.class);
        Assertions.assertEquals(objectIdIssuer, objectIdIssuerDeserialized);

    }


}
