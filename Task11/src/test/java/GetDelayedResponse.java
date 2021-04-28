import io.restassured.response.Response;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

public class GetDelayedResponse {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Tests has been started");
    }

    @Test
    public void getDelayedResponse() {

        File delayedResponse = new File("src/test/resources/chemas/getDelayedResponse.json");

        Response response = when().get("https://reqres.in/api/users?delay=3");
                response.then()
                        .statusCode(200)
                        .assertThat().body(matchesJsonSchema(delayedResponse));

        System.out.println("Status Code is: " + response.statusCode());
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
