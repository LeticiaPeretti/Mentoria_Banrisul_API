package testCases.apiDeTarefas;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import testBases.apiDeTarefas.EditarTarefaTestBase;

public class PutEditarTarefas extends EditarTarefaTestBase{
	
    @Test
    public void editarTarefa(){
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .put()
        .then()
                .log().all()
                .spec(responseSpec);
    }

}

