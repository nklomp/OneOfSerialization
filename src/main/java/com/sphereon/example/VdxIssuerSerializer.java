package com.sphereon.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 * Not really needed as serialization has enough info from the annotations in the sub-types. Just provided as an example in case we have more complex
 * scenarios
 */
public class VdxIssuerSerializer extends StdSerializer<Issuer> {

    protected VdxIssuerSerializer() {
        super(Issuer.class);
    }

    /**
     * Not really needed as serialization has enough info from the annotations in the sub-types. Just provided as an example in case we have more
     * complex scenarios
     *
     * @param value
     * @param jsonGenerator
     * @param arg2
     * @throws IOException
     */
    @Override
    public void serialize(Issuer value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException {
        if (value instanceof IssuerIdObject) {
            jsonGenerator.writeObject(value);
        } else if (value instanceof IssuerString) {
            jsonGenerator.writeString(((IssuerString) value).getValue());
        }
    }
}
