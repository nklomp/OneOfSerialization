package com.sphereon.example;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class VdxIssuerDeserializer extends StdDeserializer<Issuer> {

    protected VdxIssuerDeserializer() {
        super(Issuer.class);
    }

    @Override
    public Issuer deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
      throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if ("issuer".equals(jsonParser.getCurrentName())) {
            if (VALUE_STRING.equals(currentToken)) {
                return new IssuerString(jsonParser.getText());
            } else if (START_OBJECT.equals(currentToken)) {
                return jsonParser.readValueAs(IssuerIdObject.class);
            } else {
                throw new IllegalStateException(String.format("Unexpected issuer value found %s", currentToken));
            }
        }
        return null;
    }
}
