import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {
    private By searchInput = (By.xpath("//input[@spellcheck='false']"));
    private By div = (By.cssSelector("div.LS8OJ"));

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(div).isDisplayed();
    }

    public GoogleSearchResults searchProduct(String searchText) {
        driver.findElement(searchInput).click();
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchText);
        driver.findElement(searchInput).submit();
        return new GoogleSearchResults(driver);
    }

}
