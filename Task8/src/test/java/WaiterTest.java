import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class WaiterTest extends BasePage {

    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();


    }

    @Test
    public void main() {
       // Actions actions = new Actions(driver);
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);

        String testSearchText = "монитор";
        String testResultText = "монитор";

        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.searchProduct(testSearchText);

        RozetkaSearchResults rozetkaSearchResults = new RozetkaSearchResults(driver);
        rozetkaSearchResults.ClickFirstProduct();

        RozetkaProductPage rozetkaProductPage = new RozetkaProductPage(driver);
        rozetkaProductPage.ClickToCheckout();


       // String preloaderSpinner = "//div[contains(@class,'modal__preloader')]";

        pageLoad.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']")));
        WebElement acceptYes = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']"));
        acceptYes.click();

        String preloaderLine = "//div[@class='preloader']";
        pageLoad.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preloaderLine)));


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
}

