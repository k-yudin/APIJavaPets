package io.swagger.petstore;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.swagger.petstore.CoreTest.FEATURE_UPDATE_PETS;

@Feature(FEATURE_UPDATE_PETS)
public class UpdatePetTests extends TestBase {

    @DisplayName("Update existing pet status")
    @Test
    public void testUpdatePet() {

        Long id = dataHelper.generateUniqueId();

        Response createPetResponse = apiPetMethods.createNewPetWith(id);
        checker.checkResponseCodeEquals(200, createPetResponse);

        Response updatePetResponse = apiPetMethods.updatePetStatusById(id, "sold");
        checker.checkResponseCodeEquals(200, updatePetResponse);

        Response updatedPetResponse = apiPetMethods.getPetById(id);
        checker.checkResponseCodeEquals(200, updatedPetResponse);

        checker.checkResponseHasField("status", updatedPetResponse);
        checker.checkFieldValueEquals("sold", "status", updatedPetResponse);
    }
}
