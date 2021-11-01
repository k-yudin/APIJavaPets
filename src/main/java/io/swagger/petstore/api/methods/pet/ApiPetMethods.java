package io.swagger.petstore.api.methods.pet;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.swagger.petstore.api.core.ApiCoreRequests;
import io.swagger.petstore.api.core.Endpoints;

public class ApiPetMethods {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Step("Get pets by status")
    public Response getPetsByStatus(String status) {
        return apiCoreRequests.makeGetRequest(Endpoints.FIND_BY_STATUS, status);
    }
}
