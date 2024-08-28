package jsonHandling;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import org.example.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadDataFromJsonFile {

    public static void main(String[] args) throws FileNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            JsonNode empObj = mapper.readTree(new File("D:\\Rest\\RestAssured\\src\\test\\java\\jsonHandling\\employee.json"));

            String employeeId = empObj.get("total_pages").asText();
            System.out.println("Employee:" + employeeId);

            JsonNode dataArray = empObj.get("data");
            for (JsonNode data : dataArray) {

                System.out.println("EmployeeId: " + data.get("id"));
                System.out.println("EmployeeName: " + data.get("name"));
                System.out.println("EmployeeYear: " + data.get("year"));
                System.out.println("EmployeeColour: " + data.get("color"));
                System.out.println("-------------------------------------");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
