import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaSearchResults extends BasePage {

    private By resultsGrid = By.cssSelector("div.layout_with_sidebar");
    private By productItem = By.xpath("//a[@href='https://hard.rozetka.com.ua/samsung_lc27g54tqwixci/p250703981/']");

    public RozetkaSearchResults(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.presenceOfElementLocated(resultsGrid));
    }

    public RozetkaProductPage ClickFirstProduct() {
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.elementToBeClickable(productItem));
        driver.findElement(productItem).click();
        return new RozetkaProductPage(driver);
    }
}
