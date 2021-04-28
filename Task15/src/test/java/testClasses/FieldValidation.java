package testClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObject.BasePage;
import pageObject.MainPage;

import java.util.concurrent.TimeUnit;

public class FieldValidation extends BasePage {

    @BeforeSuite(alwaysRun = true)
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name = "CharsSet")
    public static Object[][]  userData() {
        return new Object[][]{
                {"2"},
                {"$"},
                {"#"},
                {"!"},
                {"$"},
                {"@"},
                {"<"},
                {"%"},
                {"^"},
                {"a"},
                {"b"},
                {"c"},
                {"d"}
        };
    }

    @Test(groups = { "include-group" }, dataProvider = "CharsSet")
    public void verifyList(String data) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .goToFoodPage()
                .GoToMilkPage()
                .fieldValidation(data);
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
