package io.swagger.petstore.api.core;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiCoreRequests {

    @Step("Send GET request")
    public Response makeGetRequest(String url) {
        return given()
                .filter(new AllureRestAssured())
                .get(url)
                .andReturn();
    }

    @Step("Send GET request with pet status")
    public Response makeGetRequestWithStatusParameter(String url, String status) {
        return given()
                .filter(new AllureRestAssured())
                .queryParam("status", status)
                .get(url)
                .andReturn();
    }

    @Step("Send POST request with headers")
    public Response makePostRequest(String url, String body, String acceptContent, String contentType) {
        return given()
                .filter(new AllureRestAssured())
                .header(new Header(ApiHeaders.ACCEPT_CONTENT, acceptContent))
                .header(new Header(ApiHeaders.CONTENT_TYPE,contentType))
                .body(body)
                .post(url)
                .andReturn();
    }

    @Step("Send PUT request")
    public Response makePutRequest(String url, String body, String acceptContent, String contentType) {
        return given()
                .filter(new AllureRestAssured())
                .header(new Header(ApiHeaders.ACCEPT_CONTENT, acceptContent))
                .header(new Header(ApiHeaders.CONTENT_TYPE,contentType))
                .body(body)
                .put(url)
                .andReturn();
    }

    @Step("Send DELETE request")
    public Response makeDeleteRequest(String url) {
        return given()
                .filter(new AllureRestAssured())
                .delete(url)
                .andReturn();
    }
}
