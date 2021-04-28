import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import WebDriverFactoryProps.DriverType;
import WebDriverFactoryProps.WebDriverFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import static com.sun.deploy.cache.Cache.copyFile;


public class BrowserFactoryTest extends BasePage{


    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUP() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        DriverType driverType = DriverType.valueOf("FIREFOX");
        driver = webDriverFactory.createWebDriver(driverType);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void browserFactoryTest() {
        String testSearchText = "SoftServe";
        String testResultText = "SoftServe";

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.searchProduct(testSearchText);

        Assert.assertEquals(testSearchText, testResultText);

        GoogleSearchResults googleSearchResults = new GoogleSearchResults(driver);
        googleSearchResults.ClickToSoftServe();

        String verifyUrl = "https://www.softserveinc.com/uk-ua";
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, verifyUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() +"["+ LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));

            } catch (
                    IOException e) {
                e.printStackTrace();

            }
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All tests passed");
    }
}
