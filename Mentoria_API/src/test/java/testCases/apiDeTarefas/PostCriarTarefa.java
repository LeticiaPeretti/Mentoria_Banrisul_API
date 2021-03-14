package testCases.apiDeTarefas;

import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.CriarTarefasTestBase;

import static io.restassured.RestAssured.given;

public class PostCriarTarefa extends CriarTarefasTestBase {

    @Test
    public void criarTarefa(){
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec);
    }
}
