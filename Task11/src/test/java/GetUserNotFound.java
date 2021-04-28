import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetUserNotFound {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Tests has been started");
    }

    @Test
    public void getUserNotFound() {

        Response response = when().get("https://reqres.in/api/users/23");
        response.then().statusCode(404);

        System.out.println("Status Code is: " + response.statusCode());

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
