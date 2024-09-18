package com.example.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class JsonValidator {

    public Set<ValidationMessage> validateJsonSchema(String schemaFilePath, String jsonStringPath) throws IOException {

        final var objectMapper = new ObjectMapper();
        final var schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        try (final var jsonStream = inputStreamFromClasspath("json/validInput1.json");
             final var schemaStream = inputStreamFromClasspath("json/schema.json")) {

            final var json = objectMapper.readTree(jsonStream);
            final var  schema = schemaFactory.getSchema(schemaStream);

            final var validationResult = schema.validate(json);

            if (validationResult.isEmpty()) {
                System.out.println("No validation errors :-)");
            } else {
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            }

            return validationResult;
        }
    }

    private static InputStream inputStreamFromClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}


