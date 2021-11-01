package io.swagger.petstore.api.core;

import io.swagger.petstore.configs.EnvironmentConfig;

public class Endpoints {

    private static final String BASE_URL = EnvironmentConfig.getBaseURL();
    public static final String FIND_BY_STATUS = BASE_URL + "pet/findByStatus";
    public static final String PET = BASE_URL + "pet/";
}
