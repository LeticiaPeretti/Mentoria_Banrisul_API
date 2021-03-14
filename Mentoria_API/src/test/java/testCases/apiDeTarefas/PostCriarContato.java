package testCases.apiDeTarefas;

import org.junit.jupiter.api.Test;
import testBases.apiDeTarefas.CriarContatoTestBase;

import static io.restassured.RestAssured.given;


public class PostCriarContato extends CriarContatoTestBase {
	  @Test
	    public void criarContato(){
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
