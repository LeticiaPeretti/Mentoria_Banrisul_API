package testBases.apiDeTarefas;

import org.junit.jupiter.api.BeforeAll;

import Utils.FakerGenerator;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.EditarTarefaModel;



public class EditarTarefaTestBase {
	
	protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
	private static EditarTarefaModel pojoObjeto;

    @BeforeAll
    public static void setUp(){
    	buildPojoObjetc();
        buildRequestSpec();
        buildResponseSpec();
        
        
    
            
    }
     public static void buildRequestSpec() {
    	requestSpec = new RequestSpecBuilder()
    			.setBaseUri("https://api-de-tarefas.herokuapp.com")
    			.setBasePath("/tasks/4658")
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
    		 pojoObjeto = new EditarTarefaModel(
    		    " id",
    	        "title",
    	        "description",
    	        "deadLine",
    	        true
    		    );
    	    }
}

    			
    	
    	
    	
    	
    	
    	
    	
    	
   
