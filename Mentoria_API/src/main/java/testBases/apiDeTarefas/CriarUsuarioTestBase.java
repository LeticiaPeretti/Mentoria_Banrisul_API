package testBases.apiDeTarefas;

import Utils.FakerGenerator;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.CriarUsuarioModel;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;


public class CriarUsuarioTestBase {
	 protected static RequestSpecification requestSpec;
	    protected static ResponseSpecification responseSpec;
	    private static CriarUsuarioModel criarUsuarioModel;
	    private static Map<String, Object> objeto = new HashMap<String, Object>();

	    @BeforeAll
	    public static void setUp(){
	        buildObjeto();
	        buildRequestSpec();
	        buildResponseSpec();
	    }

	    public static void buildRequestSpec(){
	        requestSpec = new RequestSpecBuilder()
	                .setBaseUri("https://api-de-tarefas.herokuapp.com")
	                .setBasePath("/users")
	                .addHeader("Content-Type", "application/json")
	                .setBody(objeto)
	                .build();
	    }

	    public static void buildResponseSpec(){
	        responseSpec = new ResponseSpecBuilder()
	                .expectStatusCode(201)
	                .expectContentType(ContentType.JSON)
	                .build();
	    }

	    public static void buildUsuario(){
	        criarUsuarioModel = new CriarUsuarioModel(
	                FakerGenerator.getEmail(),
	                "123456",
	                "123456"
	        );
	    }

	    public static void buildObjeto(){
	        buildUsuario();
	        objeto.put("user", criarUsuarioModel);
	    }
	}


