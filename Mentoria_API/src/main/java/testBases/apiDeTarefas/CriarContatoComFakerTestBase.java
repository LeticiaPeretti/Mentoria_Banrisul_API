package testBases.apiDeTarefas;

import Utils.FakerGenerator;
import Utils.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.CriarContatoModel;
import org.junit.jupiter.api.BeforeAll;



public class CriarContatoComFakerTestBase {
	
	 protected static RequestSpecification requestSpec;
	    protected static ResponseSpecification responseSpec;
	    private static CriarContatoModel pojoObjeto;
	    protected String id;

	    @BeforeAll
	    public static void setUp(){
	        buildPojoObjetc();
	        buildRequestSpec();
	        buildResponseSpec();
	    }

	    public static void buildRequestSpec(){
	        requestSpec = new RequestSpecBuilder()
	                .setBaseUri("https://api-de-tarefas.herokuapp.com")
	                .setBasePath("/contacts")
	                .addHeader("Content-Type", "application/json")
	                .setBody(pojoObjeto)
	                .build();
	    }

	    public static void buildResponseSpec(){
	        responseSpec = new ResponseSpecBuilder()
	                .expectStatusCode(201)
	                .expectContentType(ContentType.JSON)
	                .build();
	    }

	    public static void buildPojoObjetc(){

	        String name = FakerGenerator.getName();
	        String lastName = FakerGenerator.getLastName();
	        String email = FakerGenerator.getEmail();
	        String age = FakerGenerator.getAge();
	        String phone = FakerGenerator.getPhone();
	        String address = FakerGenerator.getAddress();
	        String state = FakerGenerator.getState();
	        String city = FakerGenerator.getCity();

	        pojoObjeto = new CriarContatoModel(
	                name,
	                lastName,
	                email,
	                age,
	                phone,
	                address,
	                state,
	                city
	        );
	        System.out.println(email);
	        FileOperations.setProperties("contact", "name", name);
	        FileOperations.setProperties("contact", "lastName", lastName);
	        FileOperations.setProperties("contact", "email", email);
	        FileOperations.setProperties("contact", "age", age);
	        FileOperations.setProperties("contact", "phone", phone);
	        FileOperations.setProperties("contact", "address", address);
	        FileOperations.setProperties("contact", "state", state);
	        FileOperations.setProperties("contact", "city", city);
	    }


}
