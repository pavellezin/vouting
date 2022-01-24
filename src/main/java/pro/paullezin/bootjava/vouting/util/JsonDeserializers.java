package pro.paullezin.bootjava.vouting.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import pro.paullezin.bootjava.vouting.config.WebSecurityConfig;

import java.io.IOException;

public class JsonDeserializers {

    public static class PasswordDesirializer extends JsonDeserializer<String> {
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            ObjectCodec oc = p.getCodec();
            JsonNode node = oc.readTree(p);
            String rawPassword = node.asText();
            return WebSecurityConfig.PASSWORD_ENCODER.encode(rawPassword);
        }
    }
}