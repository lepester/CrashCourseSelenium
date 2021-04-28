import factory.DriverManager;
import factory.DriverFactoryManager;
import factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.MainPage;

public class ProductSearchTest {

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
    }

    @Test
    public void productSearchTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForGraphicsCard();
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
