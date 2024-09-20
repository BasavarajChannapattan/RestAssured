package tests.SimpleJSonRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {


    @Test
    public void postRequest(){
        //declare the obj of the class
        POJO_PostRequest data = new POJO_PostRequest();
        data.setId(2);
        data.setFirst_Name("Balu");
        data.setLast_Name("Kumar");
        data.setJob("Designer");

        Response res=given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("http://localhost:3000/userData")
                .then()
                .statusCode(201).extract().response();

        System.out.println(res.body().asString());

    }
}
