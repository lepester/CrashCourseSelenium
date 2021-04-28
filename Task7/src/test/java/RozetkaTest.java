import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test
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

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
