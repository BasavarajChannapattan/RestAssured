package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;
    public RequestSpecification requestSpecifications() throws IOException {

        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl")).addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValues(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream("C:\\Users\\basavarajag\\IdeaProjects\\ApiFramework\\src\\test\\java\\resources\\global.properties");
        prop.load(fs);
        return prop.getProperty(key);

    }

    public Object getJsonPath(Response response, String key)
    {
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return js.get(key);

    }
}
