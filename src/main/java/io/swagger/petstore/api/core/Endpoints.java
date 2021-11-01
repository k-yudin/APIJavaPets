package io.swagger.petstore.api.core;

import io.swagger.petstore.configs.EnvironmentConfig;

public class Endpoints {

    private static final String BASE_URL = EnvironmentConfig.getBaseURL();
    private static final String FIND_BY_STATUS = BASE_URL + "pet/findByStatus";
    private static final String PET = BASE_URL + "pet/";
}
