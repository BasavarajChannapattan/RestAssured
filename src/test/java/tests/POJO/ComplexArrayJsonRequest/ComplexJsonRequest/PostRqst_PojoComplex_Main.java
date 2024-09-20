package tests.POJO.ComplexArrayJsonRequest.ComplexJsonRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRqst_PojoComplex_Main {

   @Test(enabled=false)
    public void ComplexJson(){
        PostRequest_PojoComplex_Adress Address = new PostRequest_PojoComplex_Adress();
        Address.setH_No("505/10");
        Address.setStreet("XYZ Street");
        Address.setZipCode("12345");

        PostRqst_PojoComplex_BasicInfo BasicInfo = new PostRqst_PojoComplex_BasicInfo();
        BasicInfo.setFirstName("John");
        BasicInfo.setLastName("Doe");
        BasicInfo.setCourseName("Sdet");
        BasicInfo.setDesignation("Test Lead");
        BasicInfo.setMentorName("Basava");
        BasicInfo.setId("8723");
        BasicInfo.setAddress(new PostRequest_PojoComplex_Adress[]{Address});

        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .body(BasicInfo)
                        .post("http://localhost:3000/userData");

        System.out.println(res.statusCode());
        System.out.println(res.body().asString());
    }
}
