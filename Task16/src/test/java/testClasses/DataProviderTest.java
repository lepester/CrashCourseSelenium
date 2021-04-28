package testClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.BasePage;
import pageObject.HomePage;

import java.util.concurrent.TimeUnit;

public class DataProviderTest extends BasePage {


    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "searchText")
    public static Object[][] searchText() {
        return new Object[][] {
                {"монитор"},
                {"микроволновая печь"},
                {"видеокарта"}
        };
    }

    @Test(dataProvider = "searchText")
    public void dataProviderTest(String searchText) {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        homePage.openPage()
                .SearchProduct(searchText)
                .goToFirstProductPage();

        softAssert.assertEquals(driver.getTitle(), searchText);
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
