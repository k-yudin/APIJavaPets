package io.swagger.petstore;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.swagger.petstore.CoreTest.FEATURE_ADD_PETS;

@Feature(FEATURE_ADD_PETS)
public class AddPetTests extends TestBase {

    @DisplayName("Add new pet")
    @Test
    public void createNewPet() {

        Long id = dataHelper.generateUniqueId();

        Response createPetResponse = apiPetMethods.createNewPetWith(id);
        checker.checkResponseCodeEquals(200, createPetResponse);

        Response getPetResponse = apiPetMethods.getPetById(id);
        checker.checkResponseCodeEquals(200, getPetResponse);
    }
}
