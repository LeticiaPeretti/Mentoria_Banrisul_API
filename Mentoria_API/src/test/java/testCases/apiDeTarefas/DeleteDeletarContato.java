package testCases.apiDeTarefas;
import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.DeletarContatoTestBase;

import static io.restassured.RestAssured.given;


public class DeleteDeletarContato extends DeletarContatoTestBase {

    @Test
    public void deletarContato(){
        given()
                .spec(requestSpec)
        .when()
                .delete()
        .then()
                .log().all()
                .spec(responseSpec);
    }


}
