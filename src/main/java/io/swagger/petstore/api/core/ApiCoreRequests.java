package io.swagger.petstore.api.core;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiCoreRequests {

    @Step("Send GET request with pet status")
    public Response makeGetRequest(String url, String status) {
        return given()
                .filter(new AllureRestAssured())
                .queryParam("status", status)
                .get(url)
                .andReturn();
    }

    @Step("Send POST request")
    public Response makePostRequest(String url, String body) {
        return given()
                .filter(new AllureRestAssured())
                .body(body)
                .post(url)
                .andReturn();
    }

    @Step("Send PUT request")
    public Response makePutRequest(String url, String body) {
        return given()
                .filter(new AllureRestAssured())
                .body(body)
                .put(url)
                .andReturn();
    }

    @Step("Send DELETE request")
    public Response makeDeleteRequest(String url, String id) {
        return given()
                .filter(new AllureRestAssured())
                .param(id)
                .delete(url)
                .andReturn();
    }
}
