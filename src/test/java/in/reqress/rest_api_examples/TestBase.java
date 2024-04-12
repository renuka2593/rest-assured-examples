package in.reqress.rest_api_examples;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private Properties properties;

    @BeforeClass
    public void setUp() {
        String environment = System.getProperty("env", "prod");
        loadProperties(environment);
        RestAssured.baseURI = properties.getProperty("baseURI");
    }

    private void loadProperties(String environment) {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/reqress/" + environment + ".properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
