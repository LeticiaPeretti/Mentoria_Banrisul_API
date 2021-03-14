package testBases.apiDeTarefas;

import Utils.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testCases.apiDeTarefas.LoginModel;

import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;



public class LoginTestBases {
	protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static LoginModel loginModel;
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
                .setBasePath("/sessions")
                .addHeader("Content-Type", "application/json")
                .setBody(objeto)
                .build();
    }

    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void buildLogin(){
        loginModel = new LoginModel(
                FileOperations.getProperties("userData").getProperty("email"),
                "123456"
        );
    }

    public static void buildObjeto(){
        buildLogin();
        objeto.put("session", loginModel);
    }


}
