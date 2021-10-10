package core;

import io.restassured.http.ContentType;

public interface Constantes {

    String APP_BASE_URL = "https://reqres.in/api/";
    Integer APP_PORT = null;
    String APP_BASE_PATH = "";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 90000L;


}
