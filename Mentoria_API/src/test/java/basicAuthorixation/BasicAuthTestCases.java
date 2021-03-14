package basicAuthorixation;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class BasicAuthTestCases {
	
	@Test
	public void basicAuth() {
		given()
		
		.when()
		       .get("https://admin:senha@restapi.wcaquino.me/basicauth")
		.then()
		       .log().all();
	}
	
	@Test
	public void basicAuthTwo() {
		given()
		       .log().all() //mostra o que esta enviando
		       .auth().preemptive().basic("admin", "senha")
		.when()
		       .get("https://restapi.wcaquino.me/basicauth")
		.then()
		       .log().all();
	}

}
