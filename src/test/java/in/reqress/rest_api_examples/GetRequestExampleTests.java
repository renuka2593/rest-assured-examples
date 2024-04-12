package in.reqress.rest_api_examples;

import in.reqress.data.models.UserDataResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import in.reqress.rest_api_examples.endpoints.Endpoints;
import in.reqress.dataproviders.TestDataProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestExampleTests extends TestBase {

    @Test(dataProvider = "pageNumbers", dataProviderClass = TestDataProvider.class)
    public void shouldBeAbleToGetTheListOfUser(int page) {
        given().
                queryParam("page", page).
                when().
                get(Endpoints.USERS).
                then().
                assertThat().
                statusCode(200)
                .body("page", equalTo(page));
    }

    @Test(dataProvider = "pageNumbers", dataProviderClass = TestDataProvider.class)
    public void shouldBeDeserializeResponseInClassType(int page) {
        Response response = given().
                queryParam("page", page).
                when().
                get(Endpoints.USERS);
        // Response Body Deserialization for complex json structure
        UserDataResponse responseBody = response.as(UserDataResponse.class);
        System.out.println("Response Body: " + responseBody.getPage());
    }


}
