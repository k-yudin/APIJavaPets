package io.swagger.petstore.configs;

import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = EnvProperties.getInstance();

    public static String getBaseURL() {
        //+++++++In case we need to use development test environment+++++++//
        String devUrl = "https://petstore.swagger.io/v2_dev/";
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
        String prodUrl = "https://petstore.swagger.io/v2/";
        String envMode = properties.getProperty("ENVIRONMENT");

        switch (envMode) {
            case ("dev"):
                return devUrl;
            case ("prod"):
                return prodUrl;
        }
        return null;
    }
}
