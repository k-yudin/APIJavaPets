package io.swagger.petstore;


import io.swagger.petstore.api.methods.pet.ApiPetMethods;
import io.swagger.petstore.helpers.Checker;
import io.swagger.petstore.helpers.DataHelper;

public class TestBase extends CoreTest {

    protected final DataHelper dataHelper = new DataHelper();
    protected final Checker checker = new Checker();
    protected final ApiPetMethods apiPetMethods = new ApiPetMethods();

}
