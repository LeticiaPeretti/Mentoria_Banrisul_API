package viaCep;

import org.junit.jupiter.api.Test;

import testBases.viaCep.SimpleTestBase;

import static io.restassured.RestAssured.given;

public class GetNewSimpleTestCase extends SimpleTestBase{
	
	@Test
	public void newSimpleTestCase() {
		given()
		       .spec(requestSpec)
		       .log().all()
		.when()
		       .get()
		.then()
		       .log().all()
		       .spec(responseSpec)
		
		;
	}

}
