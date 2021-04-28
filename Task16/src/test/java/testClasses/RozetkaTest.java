package testClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.BasePage;
import pageObject.HomePage;

import java.util.concurrent.TimeUnit;

public class RozetkaTest extends BasePage {


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

    @DataProvider(name = "SearchQuery")
    public static Object[][] searchText() {
        return new Object[][] {
                {"монитор"},
                {"микроволновая печь"},
                {"видеокарта"},
        };
    }

    @Test(dataProvider = "SearchQuery")
    public void rozetkaTest(String data) {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(data);

        System.out.println(data);


    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

}
