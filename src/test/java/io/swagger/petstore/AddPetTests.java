package io.swagger.petstore;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.swagger.petstore.CoreTest.FEATURE_ADD_PETS;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Feature(FEATURE_ADD_PETS)
public class AddPetTests extends TestBase {

    @DisplayName("Add new pet")
    @Test
    public void testAddNewPet() {

        Long id = dataHelper.generateUniqueId();

        Response createPetResponse = apiPetMethods.createNewPetWith(id);
        checker.checkResponseCodeEquals(200, createPetResponse);

        Response getPetResponse = apiPetMethods.getPetById(id);
        checker.checkResponseCodeEquals(200, getPetResponse);
    }

    @DisplayName("Add pet with existing id should fail")
    @Test
    public void testAddPetWithExistingId() {
        Response getPetsResponse = apiPetMethods.getPetsByStatus("available");
        checker.checkResponseCodeEquals(200, getPetsResponse);

        Long existingId = getPetsResponse.body().path("[0].id");
        if (existingId == null) {
            existingId = dataHelper.generateUniqueId();
            Response createPetResponse = apiPetMethods.createNewPetWith(existingId);
            checker.checkResponseCodeEquals(200, createPetResponse);
        }

        Response duplicateCreateResponse = apiPetMethods.createNewPetWith(existingId);
        assertNotEquals(200, duplicateCreateResponse.statusCode(),
                "Expected non-200 when creating pet with existing id.");
    }
}
