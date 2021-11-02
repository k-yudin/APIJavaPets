package io.swagger.petstore.api.methods.pet;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.swagger.petstore.api.core.ApiCoreRequests;
import io.swagger.petstore.api.core.Endpoints;
import io.swagger.petstore.builders.PetJsonBuilder;

public class ApiPetMethods {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Step("Get pets by status")
    public Response getPetsByStatus(String status) {
        return apiCoreRequests.makeGetRequestWithStatusParameter(Endpoints.FIND_BY_STATUS, status);
    }

    @Step("Get pet by id: {id}")
    public Response getPetById(Long id) {
        return apiCoreRequests.makeGetRequest(Endpoints.PET + id.toString());
    }

    @Step("Create new pet with id: {id}")
    public Response createNewPetWith(Long id) {

        String requestBody = new PetJsonBuilder()
                .addPetId(id)
                .addCategory(0, "string")
                .addPetName("gera")
                .addPhotoUrls("string")
                .addTags(0, "string")
                .addStatus("available")
                .build();

        return sendCreatePetRequest(requestBody);
    }

    @Step("Updating existing pet status: {newStatus} by id: {id}")
    public Response updatePetStatusById(Long id, String newStatus) {

        String requestBody = new PetJsonBuilder()
                .addPetId(id)
                .addCategory(0, "string")
                .addPetName("gera")
                .addPhotoUrls("string")
                .addTags(0, "string")
                .addStatus(newStatus)
                .build();

        return sendUpdatePetRequest(requestBody);
    }

    @Step("Deleting pet by id: {id}")
    public Response deletePetById(Long id) {
        return apiCoreRequests.makeDeleteRequest(Endpoints.PET + id.toString());
    }

    private Response sendCreatePetRequest(String requestBody) {
        return apiCoreRequests.makePostRequest(Endpoints.PET, requestBody, "application/json", "application/json");
    }

    private Response sendUpdatePetRequest(String requestBody) {
        return apiCoreRequests.makePutRequest(Endpoints.PET, requestBody, "application/json", "application/json");
    }
}
