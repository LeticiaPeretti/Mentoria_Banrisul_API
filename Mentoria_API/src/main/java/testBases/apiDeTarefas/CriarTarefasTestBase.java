package testBases.apiDeTarefas;

import Utils.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.TarefasModel;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;


public class CriarTarefasTestBase {
	
	protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static TarefasModel tarefasModel;
    private static Map<String, Object> objeto = new HashMap<String, Object>();
    private static String token = FileOperations.getProperties("userData").getProperty("token");

    @BeforeAll
    public static void setUp(){
        buildObjeto();
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/tasks")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .setBody(objeto)
                .build();
    }

    public static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void buildTarefa(){
        String title = "Tarefinha";
        String description = "Minha Primeira Tarefa";
        String deadline = "2018-08-21 15:00:00";
        boolean done = true;

        tarefasModel = new TarefasModel(
                title,
                description,
                deadline,
                done
        );
    }

    public static void buildObjeto(){
        buildTarefa();
        objeto.put("task", tarefasModel);
    }


}
