import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaHomePage extends BasePage{

    private By searchInput = By.cssSelector("input.search-form__input");
    private By searchButton = By.cssSelector("button.search-form__submit");
    private By sideBar = By.cssSelector("main.content_type_main");

    public RozetkaHomePage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(sideBar).isDisplayed();
    }

    public RozetkaSearchResults searchProduct(String searchProduct){
        driver.findElement(searchInput).click();
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchProduct);
        driver.findElement(searchButton).click();
        return new RozetkaSearchResults(driver);
    }
}
