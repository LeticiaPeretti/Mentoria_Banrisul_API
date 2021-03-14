package testCases.apiDeTarefas;

import Utils.FileOperations;
import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.CriarUsuarioTestBase;

import static io.restassured.RestAssured.given;

public class PostCriarUsuario extends CriarUsuarioTestBase {

    @Test
    public void criarUsuario(){
        String email =
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec).extract().path("data.attributes.email");

        FileOperations.setProperties("userData", "email", email);
    }
}

