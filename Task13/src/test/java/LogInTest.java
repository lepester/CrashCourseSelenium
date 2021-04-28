import factory.DriverManager;
import factory.DriverFactoryManager;
import factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.*;

import java.util.concurrent.TimeUnit;

public class LogInTest {
    WebDriver driver;
    DriverManager driverManager;

    @BeforeTest
    public void setUp() {
        DriverType type = DriverType.fromValue(System.getenv("browser").toUpperCase());
        driverManager = DriverFactoryManager.getDriver(type);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void logInTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForGraphicsCard()
                .ProductPage()
                .logIn()
                .createAccount()
                .enterYourName()
                .enterEmail()
                .enterPassword()
                .reEnterPassword();
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driverManager.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
