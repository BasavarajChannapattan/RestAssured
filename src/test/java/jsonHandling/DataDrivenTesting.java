package jsonHandling;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DataDrivenTesting {

    static WebDriver driver;

    @BeforeClass
     void setup()
    {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

    }

    @AfterClass
    void teardown()
    {
        driver.close();
    }

   @Test(dataProvider="dp")
   void login(String data){

        String users[] = data.split(",");
       driver.get("https://demo.nopcommerce.com/login");
        driver.findElement(By.id("Email")).sendKeys(users[0]);
        driver.findElement(By.id("Password")).sendKeys(users[1]);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        String actualTitle = driver.getTitle();
        System.out.println("actual title: " + actualTitle);
//        String expectedTitle = "Welcome to our store";
//        Assert.assertEquals(expectedTitle, actualTitle);

    }

@DataProvider(name="dp")
Object[] readJson() throws IOException, ParseException {
    JSONParser json = new JSONParser();
    FileReader reader = new FileReader("D:\\Rest\\RestAssured\\src\\test\\java\\jsonHandling\\testData.json");
    Object obj =json.parse(reader);
    JSONObject usersLoginObj= (JSONObject) obj;
    System.out.println("usersLoginObj" + usersLoginObj);
    JSONArray usersLoginArray =(JSONArray) usersLoginObj.get("userlogins");
    String arr[] = new String[usersLoginArray.size()];
    for(int i =0; i<usersLoginArray.size(); i++)
    {
        JSONObject users = (JSONObject) usersLoginArray.get(i);
        System.out.println("users" + users);
        String user = (String)users.get("username");
        String password = (String)users.get("password");
        arr[i] = user + "," + password;

    }
  return arr;
  }

}
