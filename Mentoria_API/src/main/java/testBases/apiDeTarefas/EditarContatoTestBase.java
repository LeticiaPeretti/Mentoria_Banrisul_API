package testBases.apiDeTarefas;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.EditaContatoModel;

import org.junit.jupiter.api.BeforeAll;

import Utils.FakerGenerator;



public class EditarContatoTestBase {
	protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static EditaContatoModel pojoObjeto; 
	
    @BeforeAll
    public static void setUp(){
        //buildObject();
        buildPojoObjetc();
        buildRequestSpec();
        buildResponseSpec();
    }
    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts/2939")
                .addHeader("Content-Type", "application/json")
                .setBody(pojoObjeto)
                .build();
    }

    
    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }


    public static void buildPojoObjetc(){
        pojoObjeto = new EditaContatoModel(
        	
        		FakerGenerator.getName(),
        		FakerGenerator.getLastName(),
        		FakerGenerator.getEmail(),
                "35",
                FakerGenerator.getPhone(),
                FakerGenerator.getAddress(),
        		FakerGenerator.getState(),
                FakerGenerator.getCity()
        );
    }


}
