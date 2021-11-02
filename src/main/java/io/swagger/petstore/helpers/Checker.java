package io.swagger.petstore.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class Checker {

    private final ResponseHelper responseHelper = new ResponseHelper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Step("Verify that response has field: {fieldName}")
    public void checkResponseHasField(String fieldName, Response response) {

        String responseBody = response.body().asString();

        try {
            boolean result = objectMapper.readTree(responseBody).has(fieldName);
            assertTrue(result, "Response body doesn't have parameter " + fieldName);
        } catch (JsonProcessingException e) {
            fail("Не получилось прочитать тело ответа" + e.getMessage());
        }
    }

    @Step("Verify that received status code equals to: {expectedCode}")
    public void checkResponseCodeEquals(int expectedCode, Response response) {
        assertEquals(expectedCode, response.statusCode(), "Status code doesn't match expected value!");
    }

    @Step("Verify that response has field {fieldName} with value: {expectedValue}")
    public void checkFieldValueEquals(String expectedValue, String fieldName, Response response) {
        String fieldValue = responseHelper.getFieldValue(fieldName, response);
        assertEquals(expectedValue, fieldValue, "Response body doesn't have parameter value: " + fieldName);
    }

    @Step("Verify that response has field {fieldName} with values: {expectedValue}")
    public void checkFieldValuesEquals(String fieldName, String expectedValue, Response response) {
        assertTrue(responseHelper.hasFieldValue(fieldName, expectedValue, response),
                "Response field doesn't have values: " + expectedValue);
    }
}
