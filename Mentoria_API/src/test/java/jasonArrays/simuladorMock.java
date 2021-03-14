package jasonArrays;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;

public class simuladorMock {
	
	@Test
	public void simuladorMock() {
		 Response payload = 
		given()
		       .baseUri("http://5b847b30db24a100142dce1b.mockapi.io/")
		       .basePath("/api/v1/simulador")
		.when()
		       .get()
		 .then()
		        .contentType(ContentType.JSON)
		        .log().all().extract().response();
		
		ArrayList<String> ValorActual = payload.then().extract().path("valor");
		
		String[] mesesExpected = {"112", "124", "136", "148"};
		
		String[] valoresExpected = {"2.802", "3.174", "3.564", "3.971"};
		
		Assertions.assertArrayEquals(valoresExpected, ValorActual.toArray());
				
	    
	}

}
