import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage{

    private By resultsGrid = By.cssSelector("div.layout_with_sidebar");
    private By productItem = By.xpath("//a[@class='goods-tile__picture']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.presenceOfElementLocated(resultsGrid));


    }

    public ProductPage ClickFirstProduct() {
        WebDriverWait pageLoad = new WebDriverWait(driver, 5);
        pageLoad.until(ExpectedConditions.elementToBeClickable(productItem));
        driver.findElement(productItem).click();
        return new ProductPage(driver);

    }

}