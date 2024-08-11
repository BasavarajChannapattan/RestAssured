import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.Map;
import java.util.List;

public class JsonPathExamples {
    public static void main(String[] args) {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        JsonPath jsonPath = response.jsonPath();
        List<Object> users = jsonPath.getList("data");

        // Print the full list of users
        System.out.println("Users: " + users);
        for (Object user : users) {
            @SuppressWarnings("unchecked")
            Map<String, Object> userMap = (Map<String, Object>) user;

            // Extract and print the first_name
            String firstName = (String) userMap.get("first_name");
            System.out.println("First Name: " + firstName);
        }

    }
}

