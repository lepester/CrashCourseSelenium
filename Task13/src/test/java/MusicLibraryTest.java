import factory.DriverManager;
import factory.DriverFactoryManager;
import factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.*;

import java.util.concurrent.TimeUnit;

public class MusicLibraryTest {
    WebDriver driver;
    DriverManager driverManager;

    @BeforeTest
    public void setUp() {
        DriverType type = DriverType.fromValue(System.getenv("browser").toUpperCase());
        driverManager = DriverFactoryManager.getDriver(type);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void musicLibraryTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage().musicLibraryPage();

        MusicLibraryPage musicLibraryPage = new MusicLibraryPage(driver);
        musicLibraryPage.verifyMusicLibraryPage();
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driverManager.quitDriver();
    }
}
