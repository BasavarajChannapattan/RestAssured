package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;
import resources.constants;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Integration_Tests  extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
     static Object place_id;


    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
       res=given().spec(requestSpecifications())
                .body(data.addPlacePayLoad(name, language, address));
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {

        constants resourceApi= constants.valueOf(resource);
        System.out.println(resourceApi.getResources());

         resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
         if(method.equalsIgnoreCase("POST"))
         response =res.when().post(resourceApi.getResources());
        else if(method.equalsIgnoreCase("GET"))
               response = res. when().get(resourceApi.getResources());

    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(Integer int1) {
       assertEquals(response.statusCode(),200);


    }

    @Then("{string} in response body is {string}")
    public void statusCodeShouldBe(String keyValue, String ExpectedValue) {
        assertEquals(getJsonPath(response ,keyValue),ExpectedValue);
    }

    @Then("verify the place_Id created maps to {string} using {string}")
    public void verify_the_place__id_created_maps_to_using(String expectedName, String resource) throws IOException {
        place_id =getJsonPath(response, "place_id").toString();;
        res=given().spec(requestSpecifications()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String name = getJsonPath(response,"name").toString();
        assertEquals(name,expectedName);
        if (response != null) {
            System.out.println("Response body: " + response.getBody().asString());
        } else {
            System.out.println("Response is null");
        }

    }

    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {
       res = given().spec(requestSpecifications())
               .body(data.deletePlacePayLoad((String) place_id));
    }

    public static class Hooks_Steps {

        @Given("this is the first step")
        public void this_is_the_first_step() {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java.PendingException();
        }
        @When("this is the second step")
        public void this_is_the_second_step() {
            // Write code here that turns the phrase above into concrete actions
            //throw new io.cucumber.java.PendingException();
        }
        @Then("this is the third step")
        public void this_is_the_third_step() {
            // Write code here that turns the phrase above into concrete actions
           // throw new io.cucumber.java.PendingException();
        }


    }

}