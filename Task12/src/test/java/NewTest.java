import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewTest extends BasePage{


    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void searchProduct() {
        String testSearchText = "монитор";
        String testResultText = "монитор";

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(testSearchText);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.ClickFirstProduct();

        Assert.assertEquals(testSearchText, testResultText);


    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}
