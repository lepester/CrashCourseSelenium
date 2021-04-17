import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class RozetkaTest extends BasePage{

    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(invocationCount = 5)
    public void rozetkaTest() {
        String testSearchText = "rozetka";
        String testResultText = "rozetka";
        String productTitle = "Монитор";

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.searchProduct(testSearchText);

        Assert.assertEquals(testSearchText, testResultText);

        GoogleSearchResults searchResultPage = new GoogleSearchResults(driver);
        searchResultPage.ClickToRozetka();

        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.searchProduct(productTitle);

        RozetkaSearchResults rozetkaSearchResults = new RozetkaSearchResults(driver);
        rozetkaSearchResults.ClickFirstProduct();

        String expectedProductTitle = "Монитор";

        Assert.assertEquals(productTitle, expectedProductTitle);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}
