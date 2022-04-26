package stepDefs;

import baseSteps.BaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;

import java.util.List;

public class SwaggerSteps extends BaseSteps {

    String responseCode;

    @Given("^Uri should be ready$")
    public void uri_should_be_ready(){
       RestAssured.baseURI = "https://generator.swagger.io/";
    }

    @When("^Send a sample get request$")
    public void send_a_sample_get_request(){
        List<String> responseList = swaggerGet();
        responseCode = responseList.get(0);
    }

    @Then("^Http status code should be \"([^\"]*)\"$")
    public void http_status_code_should_be(String expectedCode){

        if (responseCode.equals(expectedCode)){
            System.out.println("TEST SUCCEED");
        }
        else{
            System.out.println("TEST FAILED");
        }
    }
}
