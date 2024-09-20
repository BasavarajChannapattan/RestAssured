package tests.OrgJson.SimpleOrgJson.ComplexOrgJson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestOrgJsonArray {

    @Test
    public void complexArrayJson()
    {

        JSONArray Address = new JSONArray();
        JSONObject arrayObj1= new JSONObject();
        arrayObj1.put("H_No", "123324/92354");
        arrayObj1.put("Street", "Test Street");
        arrayObj1.put("City", "BLR");

        JSONObject arrayObj2= new JSONObject();
        arrayObj2.put("H_No", "123324/92354");
        arrayObj2.put("Street", "Test Street");
        arrayObj2.put("City", "BLR");

        Address.add(arrayObj1);
        Address.add(arrayObj2);

      JSONObject BasicInfo =new JSONObject();
      BasicInfo.put("Name", "John Doe");
      BasicInfo.put("Age", 30);
      BasicInfo.put("Gender", "Male");
      BasicInfo.put("Email", "johndoe@example.com");
      BasicInfo.put("Phone", "9876543210");
      BasicInfo.put("Address", Address);
        Response res =
                given()
                        .contentType("application/json")
                        .body(BasicInfo.toString())
                        .when()
                        .post("http://localhost:3000/userData")
                        .then()
                        .statusCode(201)
                        .extract().response();
        System.out.println(res.body().asString());
    }
}
