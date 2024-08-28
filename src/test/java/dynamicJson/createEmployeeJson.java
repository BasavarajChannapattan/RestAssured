package dynamicJson;

import dynamicJson.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class createEmployeeJson {


    @Test
    public void createEmployeeJsonArray() throws JsonProcessingException {

        Employee emp1 = new Employee();
        emp1.setFirstName("Basava");
        emp1.setLastName("Gopal");
        emp1.setAge(30);
        emp1.setSalary("300000");

        Employee emp2 = new Employee();
        emp2.setFirstName("Karthik");
        emp2.setLastName("Raman");
        emp2.setAge(28);
        emp2.setSalary("500000");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(emp1);
        employees.add(emp2);

 //to convert employess class obj to json array payload

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArrayPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);

        System.out.println("jsonArrayPayload = " + jsonArrayPayload);

        //will send data to the server

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("http://httpbin.org/post");

        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(jsonArrayPayload);

        Response response = requestSpec.post();

        System.out.println("Response  body");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        ResponseBody responseBody = response.getBody();
        JsonPath jsonPath = responseBody.jsonPath();
        List<Employee> allEmployees = jsonPath.getList("json", Employee.class);
        for(Employee employee : allEmployees)
        {
            System.out.println("Employees firtsName:" + employee.getFirstName());
        }




    }
}
