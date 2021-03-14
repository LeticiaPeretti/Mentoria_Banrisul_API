package testCases.apiDeTarefas;

import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.LoginTestBases;

import static io.restassured.RestAssured.given;

public class PostLogin extends LoginTestBases{

    @Test
    public void login(){
        Response payload =
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec).extract().response();

        String token = payload.then().extract().path("data.attributes.auth-token");
        String userId = payload.then().extract().path("data.id");

        FileOperations.setProperties("userData", "token", token);
        FileOperations.setProperties("userData", "userId", userId);
    }
}

