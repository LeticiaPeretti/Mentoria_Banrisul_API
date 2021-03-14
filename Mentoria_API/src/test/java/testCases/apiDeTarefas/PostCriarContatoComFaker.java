package testCases.apiDeTarefas;


import Utils.FileOperations;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.CriarContatoComFakerTestBase;

import static io.restassured.RestAssured.given;

public class PostCriarContatoComFaker extends CriarContatoComFakerTestBase {
    @Test
    public void criarContatoExtraindoId(){
        id =
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec).extract().path("data.id");

        FileOperations.setProperties("contact", "id", id);

        deletaContato();
    }

    @Test
    public void criarContatoFazendoTesteDeContrato(){
        Response payload =
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpec).extract().response();

        System.out.println("Estou feliz!");
        id = payload.then().extract().path("data.id");

        String nomeDaResposta = payload.then().extract().path("data.attributes.name");
        String nomeGuardado = FileOperations.getProperties("contact").getProperty("name");

        Assertions.assertEquals(nomeGuardado,nomeDaResposta);

        deletaContato();

        payload.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/CriarContatoJsonSchema.json"));
    }

    public void deletaContato(){
        given().when().delete("https://api-de-tarefas.herokuapp.com/contacts/" + id).then();
    }
}

