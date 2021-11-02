package io.swagger.petstore.helpers;

import io.restassured.response.Response;
import java.util.List;

public class ResponseHelper {

    public String getFieldValue(String fieldName, Response response) {

        String responseBody = response.body().path(fieldName).toString();
        return responseBody;
    }

    public Boolean hasFieldValue(String field, String value, Response response) {

        List<String> responseBody = response.body().path(field);
        return responseBody
                .stream()
                .allMatch(x -> x.equals(value));
    }
}
