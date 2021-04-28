import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;

public class PostCreateUser {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Tests has been started");
    }

    @Test
    public void postCreateTest() {

        RestAssured.baseURI = "https://reqres.in/api/users";

        File jsonCreateUser = new File("src/test/resources/postCreateUser.json");

        RestAssured.given()
                .body(jsonCreateUser)
                .post()
                .then()
                .log().all()
                .statusCode(201);

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
