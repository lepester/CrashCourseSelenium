import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class OOpTest extends BasePage{


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

    @Test(invocationCount = 6)
    public void searchProduct() {
        String testSearchText = "монитор";

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(testSearchText);

        String expectedResult = driver.getTitle();
        String actualResult = "Мониторы - ROZETKA | Купить монитор для компьютера в Киеве: цена, отзывы, продажа";
        Assert.assertEquals(actualResult, expectedResult);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.ClickFirstProduct();
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
