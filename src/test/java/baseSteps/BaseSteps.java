package baseSteps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class BaseSteps {

    public static List<String> SwaggerPost (String name, String surname){

        List<String> ResponseList = new ArrayList<>();
        int statusCode;
        String responseCode;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"first_name\": \""+name+"\",\n" +
                        "\t\"last_name\": \""+surname+"\"\n" +
                        "}")
                .accept(ContentType.JSON).log().all()
                .post("api/swagger.json")
                .prettyPeek().then().extract().response();

        statusCode = response.getStatusCode();
        responseCode = Integer.toString(statusCode);
        ResponseList.add(responseCode);
        return ResponseList;
    }

    public List<String> SwaggerGet (){

        List<String> ResponseList = new ArrayList<>();
        int statusCode;
        String responseCode;

        Response response = RestAssured.given()
                .contentType("application/json")
                .accept(ContentType.JSON).log().all()
                .get("api/swagger.json")
                .prettyPeek().then().extract().response();

        statusCode = response.getStatusCode();
        responseCode = Integer.toString(statusCode);
        ResponseList.add(responseCode);
        return ResponseList;
    }

    public List<String> SwaggerDelete (){

        List<String> ResponseList = new ArrayList<>();
        int statusCode;
        String responseCode;

        Response response = RestAssured.given()
                .contentType("application/json")
                .accept(ContentType.JSON).log().all()
                .delete("api/swagger.json")
                .prettyPeek().then().extract().response();

        statusCode = response.getStatusCode();
        responseCode = Integer.toString(statusCode);
        ResponseList.add(responseCode);
        return ResponseList;
    }
}
