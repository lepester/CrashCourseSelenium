package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BasePage;

public class SoftServePage extends BasePage {

    private By header = By.cssSelector("nav.moodle-has-zindex");
    public SoftServePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.visibilityOfElementLocated(header));
    }

}
