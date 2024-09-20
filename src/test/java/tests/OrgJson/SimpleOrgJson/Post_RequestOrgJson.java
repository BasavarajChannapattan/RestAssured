package tests.OrgJson.SimpleOrgJson;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class Post_RequestOrgJson {

    public static void main(String[] args) {
        JSONObject orgJsonObject = new JSONObject();
        orgJsonObject.put("FirstName", "John");
        orgJsonObject.put("LastName", "Doe");
        orgJsonObject.put("Email", "johndoe@example.com");
        orgJsonObject.put("PhoneNumber", "123-456-7890");

        Response res =
                given()
                        .contentType("application/json")
                        .body(orgJsonObject.toString())
                        .when()
                        .post("http://localhost:3000/userData")
                        .then()
                        .statusCode(201)
                        .extract().response();

        System.out.println(res.asString());
        System.out.println(Optional.ofNullable(res.jsonPath().get("id")));
    }
}
