package tests.OrgJson.SimpleOrgJson.ComplexOrgJson;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class orgComplexJsonRequest {

    @Test
    public void complexOrgJsonRequest()
    {
        JSONObject AddressInfo = new JSONObject();
        AddressInfo.put("H_No","123213/34");
        AddressInfo.put("Street","ABC Street");
        AddressInfo.put("City","New York");

        JSONObject PersonalInfo = new JSONObject();
        PersonalInfo.put("Name","John Doe");
        PersonalInfo.put("Age",30);
        PersonalInfo.put("Gender","Male");

        Response res =
                given()
                       .header("Content-Type", "application/json")
                       .body(PersonalInfo.toJSONString() + "," + AddressInfo.toJSONString())
                       .post("http://localhost:3000/userData");

        System.out.println(res.prettyPrint());
        System.out.println("Status Code: " + res.statusCode());
        System.out.println("Response Body: " + res.body().asString());

    }
}
