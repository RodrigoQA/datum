package core;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;


public class BaseTest implements Constantes {


    public static void setup(){
        RestAssured.baseURI = APP_BASE_URL;
       // RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification =requestBuilder.build();
        ResponseSpecBuilder esponseSpecBuilder = new ResponseSpecBuilder();
        esponseSpecBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = esponseSpecBuilder.build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }
}
