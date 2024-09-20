package tests.SimpleJSonRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetRequest {

    public static void main(String[] args) {
        Response res=given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/userData")
                .then()
                .statusCode(200).extract().response();

        System.out.println(res.body().asString());
         String FirstName = res.jsonPath().get("[0].first_Name").toString();
         System.out.println("First Name: " + FirstName);
    }
}
