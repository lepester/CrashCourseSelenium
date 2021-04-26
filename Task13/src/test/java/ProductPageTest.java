import factory.DriverManager;
import factory.DriverFactoryManager;
import factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.SearchResultPage;

public class ProductPageTest {

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
                .searchForGraphicsCard()
                .verifyGraphicsCardPresented();
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driverManager.quitDriver();
    }
}