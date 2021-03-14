package testBases.apiDeTarefas;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.CriarContatoModel;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;


public class CriarContatoTestBase {
	 protected static RequestSpecification requestSpec;
	    protected static ResponseSpecification responseSpec;
	    private static Map<String, Object> objeto = new HashMap<String, Object>();
	    private static CriarContatoModel pojoObjeto;

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
	                .setBasePath("/contacts")
	                .addHeader("Content-Type", "application/json")
	                //.setBody(objeto)
	                .setBody(pojoObjeto)
	                .build();
	    }

	    public static void buildResponseSpec(){
	        responseSpec = new ResponseSpecBuilder()
	                .expectStatusCode(201)
	                .expectContentType(ContentType.JSON)
	                .build();
	    }

	    public static void buildObject(){
	        objeto.put("name", "Leticia");
	        objeto.put("last_name", "Peretti");
	        objeto.put("email", "leticiaperettii@hotmail.com");
	        objeto.put("age", "33");
	        objeto.put("phone", "995829800");
	        objeto.put("address", "Rua Dus Guri");
	        objeto.put("state", "Rio Grande do Sul");
	        objeto.put("city", "São Jerônimo");
	    }

	    public static void buildPojoObjetc(){
	        pojoObjeto = new CriarContatoModel(
	                "Leticia",
	                "Peretti",
	                "leticiaperetti@hotmail.com",
	                "33",
	                "995829800",
	                "Rua Dus Guri",
	                "Rio Grande do Sul",
	                "São Jerônimo\""
	        );
	    }


}
