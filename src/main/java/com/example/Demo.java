package com.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.StringWriter;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Jackson Core Demo");
        System.out.println("Version: 2.17.3");
        
        // Create a JSON factory
        JsonFactory factory = new JsonFactory();
        
        // Example: Generate JSON
        try {
            StringWriter writer = new StringWriter();
            JsonGenerator generator = factory.createGenerator(writer);
            
            generator.writeStartObject();
            generator.writeStringField("message", "Hello from Jackson Core!");
            generator.writeNumberField("version", 2.17);
            generator.writeEndObject();
            generator.close();
            
            System.out.println("\nGenerated JSON:");
            System.out.println(writer.toString());
            
            // Example: Parse JSON
            JsonParser parser = factory.createParser(writer.toString());
            System.out.println("\nParsed tokens:");
            while (parser.nextToken() != null) {
                JsonToken token = parser.currentToken();
                if (token == JsonToken.FIELD_NAME) {
                    System.out.println("Field: " + parser.getCurrentName());
                } else if (token.isValue()) {
                    System.out.println("Value: " + parser.getValueAsString());
                }
            }
            parser.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

