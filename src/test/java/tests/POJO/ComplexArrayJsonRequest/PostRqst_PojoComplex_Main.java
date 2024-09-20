package tests.POJO.ComplexArrayJsonRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tests.POJO.ComplexArrayJsonRequest.ComplexJsonRequest.PostRequest_PojoComplex_Adress;
import tests.POJO.ComplexArrayJsonRequest.ComplexJsonRequest.PostRqst_PojoComplex_BasicInfo;

import static io.restassured.RestAssured.given;

public class PostRqst_PojoComplex_Main {

    public static void main(String[] args) {
        PostRequest_PojoComplex_Adress[] Address1 = new PostRequest_PojoComplex_Adress[2];
        Address1[0]= new PostRequest_PojoComplex_Adress();
        Address1[1]= new PostRequest_PojoComplex_Adress();

        Address1[0].setStreet("123 Main St");
        Address1[0].setH_No("3220/10");
        Address1[0].setZipCode("1272");

        Address1[1].setStreet("323 Main St");
        Address1[1].setH_No("3221/10");
        Address1[1].setZipCode("1273");

        PostRqst_PojoComplex_BasicInfo BasicInfo1 = new PostRqst_PojoComplex_BasicInfo();
        BasicInfo1.setFirstName("John");
        BasicInfo1.setLastName("Doe");
        BasicInfo1.setCourseName("Sdet");
        BasicInfo1.setDesignation("Test Lead");
        BasicInfo1.setMentorName("Basava");
        BasicInfo1.setId("8723");
        BasicInfo1.setAddress(Address1);

        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .body(BasicInfo1)
                        .post("http://localhost:3000/userData");

        System.out.println(res.statusCode());
        System.out.println(res.body().asString());
    }
}
