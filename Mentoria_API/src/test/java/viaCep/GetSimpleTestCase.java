package viaCep;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GetSimpleTestCase {
	@Test
	public void simpleTestCase() {
		given()
	           .log().all()
		.when()
		       .get("https://viacep.com.br/ws/90020100/json/")
        .then()
	           .log().all()
	    ;
		       
	}

}
