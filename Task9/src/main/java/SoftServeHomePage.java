import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoftServeHomePage extends BasePage {

    private By softServePage = By.cssSelector("div.title__content");

    public SoftServeHomePage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(softServePage).isDisplayed();
    }
}
