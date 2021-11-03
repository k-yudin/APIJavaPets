package io.swagger.petstore;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public class CoreTest {

    public static final String FEATURE_ADD_PETS = "Add new pets to the store";
    public static final String FEATURE_GET_PETS = "Get all pets";
    public static final String FEATURE_UPDATE_PETS = "Update existing pets";
    public static final String FEATURE_DELETE_PETS = "Remove pets from the store";

    private static Boolean isAllureResultFolderClear = false;

    @BeforeAll
    public static void clearAllureResults() {
        File resultsFolder = new File("allure-results");

        if (isAllureResultFolderClear) {
            return;
        }

        if(resultsFolder.exists()) {
            for(File file : resultsFolder.listFiles()) {
                file.delete();
            }

            setResultFolderClear();
        }
    }

    private static void setResultFolderClear() {
        isAllureResultFolderClear = true;
    }
}
