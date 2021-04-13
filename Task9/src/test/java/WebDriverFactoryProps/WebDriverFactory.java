package WebDriverFactoryProps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory" + driverType);
        }
        return driver;
    }
    protected WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    protected  WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
