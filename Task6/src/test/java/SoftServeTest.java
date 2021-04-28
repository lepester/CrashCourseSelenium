import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SoftServeTest extends BasePage{

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
    public void softServeTest() {
        String testSearchText = "SoftServe IT Academy";
        String testResultText = "SoftServe IT Academy";

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.searchProduct(testSearchText);

        SearchResults searchResultPage = new SearchResults(driver);
        searchResultPage.ClickSoftServeAcademy();

        Assert.assertEquals(testSearchText, testResultText);

        String expectedSoftServe = "https://softserve.academy/";
        String actualSoftServe = "https://softserve.academy/";

        Assert.assertEquals(expectedSoftServe, actualSoftServe);
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

