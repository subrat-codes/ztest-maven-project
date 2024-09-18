package com.example.jsonschema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class JsonValidatorTest {

    private JsonValidator jsonValidator = null;

    @BeforeEach
    void setUp() {
        jsonValidator = new JsonValidator();
    }

    @Test
    void validateJsonSchema_valid() throws IOException {
        final var validationResultSet = jsonValidator.validateJsonSchema(
                "json/validInput1.json", "json/schema.json");


    }

    @Test
    void validateJsonSchema_invalid1() throws IOException {
        final var validationResultSet = jsonValidator.validateJsonSchema(
                "json/invalidInput1.json", "json/schema.json");


    }

    @Test
    void validateJsonSchema_invalid2() throws IOException {
        final var validationResultSet = jsonValidator.validateJsonSchema(
                "json/invalidInput2.json", "json/schema.json");


    }

    @Test
    void validateJsonSchema_invalid3() throws IOException {
        final var validationResultSet = jsonValidator.validateJsonSchema(
                "json/invalidInput3.json", "json/schema.json");


    }
}