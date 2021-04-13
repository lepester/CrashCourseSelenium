import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResults extends BasePage {
    private By softServePage = By.xpath("//a[@href='https://www.softserveinc.com/uk-ua']");
    private By searchResults = (By.cssSelector("div.GyAeWb"));

    public GoogleSearchResults(WebDriver driver) {
        this.driver = driver;
        driver.findElement(searchResults).isDisplayed();
    }

    public SoftServeHomePage ClickToSoftServe() {
        driver.findElement(softServePage).click();
        return new SoftServeHomePage(driver);
    }
}
