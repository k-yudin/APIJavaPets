package io.swagger.petstore;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.swagger.petstore.CoreTest.FEATURE_GET_PETS;

@Feature(FEATURE_GET_PETS)
public class GetPetTests extends TestBase {

    @DisplayName("Receive pets by available status")
    @Test
    public void testGetPetsWithAvailableStatus() {

        Response getPetsResponse = apiPetMethods.getPetsByStatus("available");
        checker.checkResponseCodeEquals(200, getPetsResponse);
        checker.checkFieldValuesEquals("status", "available", getPetsResponse);
    }
}
