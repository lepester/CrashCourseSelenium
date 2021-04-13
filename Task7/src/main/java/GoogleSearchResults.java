import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResults extends BasePage {

    private By rozetkaPage = By.xpath("//a[@href='https://rozetka.com.ua/']");
    private By searchResults = (By.cssSelector("div.GyAeWb"));

    public GoogleSearchResults(WebDriver driver) {
        this.driver = driver;
        driver.findElement(searchResults).isDisplayed();
    }

    public RozetkaHomePage ClickToRozetka() {
        driver.findElement(rozetkaPage).click();
        return new RozetkaHomePage(driver);
    }
}
