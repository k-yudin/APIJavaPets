package io.swagger.petstore;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.swagger.petstore.CoreTest.FEATURE_DELETE_PETS;

@Feature(FEATURE_DELETE_PETS)
public class DeletePetTests extends TestBase {

    @DisplayName("Delete existing pet status")
    @Test
    public void deletePet() {

        Long id = dataHelper.generateUniqueId();

        Response createPetResponse = apiPetMethods.createNewPetWith(id);
        checker.checkResponseCodeEquals(200, createPetResponse);

        Response deletePetResponse = apiPetMethods.deletePetById(id);
        checker.checkResponseCodeEquals(200, deletePetResponse);

        Response getDeletedPetResponse = apiPetMethods.getPetById(id);
        checker.checkResponseCodeEquals(404, getDeletedPetResponse);
    }
}
