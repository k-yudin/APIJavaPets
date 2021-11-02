package io.swagger.petstore.helpers;

import java.util.Date;

public class DataHelper {

    public long generateUniqueId() {
        long currentTime = new Date().getTime();
        return currentTime;
    }
}
